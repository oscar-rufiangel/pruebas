package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RPGGame extends JPanel implements KeyListener, Runnable {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Player player;
    private List<Enemy> enemies;
    private List<Item> items;
    private List<NPC> npcs;
    private List<Mission> missions;
    private boolean gameOver;
    private boolean running;
    private Image backgroundImage;
    private String currentDialogue;
    private boolean isAttacking;
    private int attackRange = 100;
    private Item treasure;
    private boolean isInteracting;
    private boolean allMissionsCompleted;
    private Random random;

    public RPGGame() {
        try {
            backgroundImage = new ImageIcon(getClass().getResource("fondo.png")).getImage();
            System.out.println("Fondo cargado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cargar el fondo: " + e.getMessage());
            backgroundImage = null;
        }

        random = new Random();
        player = new Player();
        enemies = new ArrayList<>();
        items = new ArrayList<>();
        npcs = new ArrayList<>();
        missions = new ArrayList<>();
        gameOver = false;
        running = true;
        currentDialogue = null;
        isAttacking = false;
        treasure = null;
        isInteracting = false;
        allMissionsCompleted = false;

        // Añadir enemigos en posiciones aleatorias
        for (int i = 0; i < 3; i++) {
            int x = random.nextInt(WIDTH - 50);
            int y = random.nextInt(HEIGHT - 50);
            if (i == 0) {
                enemies.add(new Goblin(x, y, player));
            } else if (i == 1) {
                enemies.add(new Orc(x, y, player));
            } else {
                enemies.add(new Dragon(x, y, player));
            }
        }

        // Añadir objetos en posiciones aleatorias
        items.add(new Item(getRandomPosition(), getRandomPosition(), "Poción de salud"));
        items.add(new Item(getRandomPosition(), getRandomPosition(), "Espada"));
        items.add(new Item(getRandomPosition(), getRandomPosition(), "Llave"));

        // Añadir NPCs en posiciones aleatorias
        List<Mission> npcMissions = new ArrayList<>();
        npcMissions.add(new Mission("Derrota a 3 enemigos", 3));
        npcMissions.add(new Mission("Encuentra la llave perdida", 1));
        npcs.add(new NPC(getRandomPosition(), getRandomPosition(), "Hola, aventurero. ¿Necesitas ayuda?", npcMissions));

        // Añadir misiones iniciales
        missions.add(new Mission("Derrota a 3 enemigos", 3));
        missions.add(new Mission("Encuentra la llave perdida", 1));
        missions.add(new Mission("Encuentra el tesoro", 1));

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        Thread gameThread = new Thread(this);
        gameThread.start();
        System.out.println("Juego inicializado.");
    }

    private int getRandomPosition() {
        return random.nextInt(WIDTH - 50);
    }

    @Override
    public void run() {
        System.out.println("Bucle del juego iniciado.");
        while (running) {
            if (!gameOver && !allMissionsCompleted) {
                update();
                repaint();
            }
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Bucle del juego detenido.");
    }

    private void update() {
        player.update();
        for (Enemy enemy : enemies) {
            enemy.update();
            checkCombat(player, enemy);
        }
        checkItems();
        checkMissions();
        checkNPCs();

        if (enemies.stream().noneMatch(Enemy::isAlive) && treasure == null) {
            treasure = new Item(getRandomPosition(), getRandomPosition(), "Tesoro");
            items.add(treasure);
            System.out.println("¡Todos los enemigos han sido derrotados! Un tesoro ha aparecido.");
        }

        if (missions.stream().allMatch(Mission::isCompleted)) {
            allMissionsCompleted = true;
            gameOver = true;
            System.out.println("¡Todas las misiones completadas! Fin del juego.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        g.drawImage(player.getSprite(), player.getX(), player.getY(), 50, 50, null);

        if (isAttacking) {
            player.drawSword(g);
        }

        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                g.drawImage(enemy.getSprite(), enemy.getX(), enemy.getY(), 50, 50, null);
            }
        }

        for (Item item : items) {
            if (!item.isCollected()) {
                g.drawImage(item.getSprite(), item.getX(), item.getY(), 30, 30, null);
            }
        }

        for (NPC npc : npcs) {
            g.drawImage(npc.getSprite(), npc.getX(), npc.getY(), 50, 50, null);
        }

        g.setColor(Color.WHITE);
        g.drawString("Salud: " + player.getHealth(), 10, 20);
        g.drawString("Inventario: " + player.getInventory(), 10, 40);
        g.drawString("Misiones: ", 10, 60);
        for (int i = 0; i < missions.size(); i++) {
            g.drawString(missions.get(i).getDescription() + " - " + missions.get(i).getProgress(), 10, 80 + i * 20);
        }

        if (currentDialogue != null) {
            g.setColor(Color.YELLOW);
            g.fillRect(50, HEIGHT - 100, WIDTH - 100, 80);
            g.setColor(Color.BLACK);
            g.drawString(currentDialogue, 60, HEIGHT - 70);
        }

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            if (allMissionsCompleted) {
                g.drawString("¡Felicidades! Has completado todas las misiones.", WIDTH / 2 - 250, HEIGHT / 2);
            } else {
                g.drawString("¡Juego Terminado!", WIDTH / 2 - 100, HEIGHT / 2);
            }
            running = false;
        }
    }

    private void checkCombat(Player player, Enemy enemy) {
        if (enemy.isAlive() && player.getBounds().intersects(enemy.getBounds())) {
            player.takeDamage(enemy.getDamage());
            enemy.takeDamage(player.getDamage());
            if (!enemy.isAlive()) {
                player.increaseEnemiesDefeated();
            }
            if (player.getHealth() <= 0) {
                gameOver = true;
            }
        }
    }

    private void checkItems() {
        for (Item item : items) {
            if (!item.isCollected() && player.getBounds().intersects(item.getBounds())) {
                player.addToInventory(item.getName());
                item.setCollected(true);
                if (item.getName().equals("Tesoro")) {
                    JOptionPane.showMessageDialog(null, "¡Has encontrado el tesoro! ¡Felicidades!");
                } else if (item.getName().equals("Llave")) {
                    JOptionPane.showMessageDialog(null, "¡Has encontrado la llave perdida!");
                }
            }
        }
    }

    private void checkMissions() {
        for (Mission mission : missions) {
            if (!mission.isCompleted()) {
                if (mission.getDescription().equals("Derrota a 3 enemigos") && player.getEnemiesDefeated() >= mission.getTarget()) {
                    mission.setCompleted(true);
                    JOptionPane.showMessageDialog(null, "¡Misión completada: " + mission.getDescription() + "!");
                }
                if (mission.getDescription().equals("Encuentra la llave perdida") && player.getInventory().contains("Llave")) {
                    mission.setCompleted(true);
                    JOptionPane.showMessageDialog(null, "¡Misión completada: " + mission.getDescription() + "!");
                }
                if (mission.getDescription().equals("Encuentra el tesoro") && player.getInventory().contains("Tesoro")) {
                    mission.setCompleted(true);
                    JOptionPane.showMessageDialog(null, "¡Misión completada: " + mission.getDescription() + "!");
                }
            }
        }
    }

    private void checkNPCs() {
        boolean isNearNPC = false;

        for (NPC npc : npcs) {
            if (player.getBounds().intersects(npc.getBounds())) {
                isNearNPC = true;
                if (!isInteracting) {
                    isInteracting = true;
                    npc.interact(player);
                }
                break;
            }
        }

        if (!isNearNPC) {
            isInteracting = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            player.moveUp();
        } else if (key == KeyEvent.VK_S) {
            player.moveDown();
        } else if (key == KeyEvent.VK_A) {
            player.moveLeft();
        } else if (key == KeyEvent.VK_D) {
            player.moveRight();
        } else if (key == KeyEvent.VK_Q) {
            if (player.getInventory().contains("Poción de salud")) {
                player.usePotion();
                player.removeFromInventory("Poción de salud");
                System.out.println("Poción de salud usada.");
            } else {
                System.out.println("No tienes una poción de salud en tu inventario.");
            }
        } else if (key == KeyEvent.VK_E) {
            if (player.getInventory().contains("Espada")) {
                player.equipSword();
                player.removeFromInventory("Espada");
                System.out.println("Espada equipada.");
            } else {
                System.out.println("No tienes una espada en tu inventario.");
            }
        } else if (key == KeyEvent.VK_R) {
            if (player.isSwordEquipped()) {
                isAttacking = true;
                player.attackWithSword();
                checkSwordAttack();
                new Thread(() -> {
                    try {
                        Thread.sleep(200);
                        isAttacking = false;
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }).start();
                System.out.println("Atacando con espada.");
            } else {
                System.out.println("No tienes una espada equipada.");
            }
        }
    }

    private void checkSwordAttack() {
        for (Enemy enemy : enemies) {
            if (enemy.isAlive() && isInAttackRange(enemy)) {
                enemy.takeDamage(player.getDamage());
                if (!enemy.isAlive()) {
                    player.increaseEnemiesDefeated();
                }
            }
        }
    }

    private boolean isInAttackRange(Enemy enemy) {
        int dx = enemy.getX() - player.getX();
        int dy = enemy.getY() - player.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance <= attackRange;
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("El Legado del Dragón");
        RPGGame gamePanel = new RPGGame();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println("Ventana del juego creada.");
    }

    // Clase Player
    public static class Player {
        private int x, y;
        private int speed;
        private int health;
        private int enemiesDefeated;
        private List<String> inventory;
        private Image sprite;
        private Image swordSprite;
        private int baseDamage;
        private int equippedDamage;
        private boolean swordEquipped;
        private int temporaryDamageBoost;
        private int attackAngle;
        private List<Mission> missions;

        public Player() {
            this.x = 100;
            this.y = 100;
            this.speed = 5;
            this.health = 100;
            this.enemiesDefeated = 0;
            this.inventory = new ArrayList<>();
            this.baseDamage = 20;
            this.equippedDamage = 0;
            this.swordEquipped = false;
            this.temporaryDamageBoost = 0;
            this.attackAngle = 0;
            this.missions = new ArrayList<>();
            try {
                this.sprite = new ImageIcon(getClass().getResource("player.png")).getImage();
                this.swordSprite = new ImageIcon(getClass().getResource("espada.png")).getImage();
                System.out.println("Sprites cargados correctamente.");
            } catch (Exception e) {
                System.out.println("Error al cargar los sprites: " + e.getMessage());
            }
        }

        public void update() {}

        public void moveUp() {
            y -= speed;
            attackAngle = 270;
        }

        public void moveDown() {
            y += speed;
            attackAngle = 90;
        }

        public void moveLeft() {
            x -= speed;
            attackAngle = 180;
        }

        public void moveRight() {
            x += speed;
            attackAngle = 0;
        }

        public void takeDamage(int damage) {
            health -= damage;
            if (health <= 0) {
                health = 0;
            }
        }

        public void increaseEnemiesDefeated() {
            enemiesDefeated++;
        }

        public void addToInventory(String item) {
            inventory.add(item);
        }

        public void removeFromInventory(String item) {
            inventory.remove(item);
        }

        public void usePotion() {
            health += 50;
            if (health > 100) {
                health = 100;
            }
        }

        public void equipSword() {
            swordEquipped = true;
            equippedDamage = 10;
        }

        public void attackWithSword() {
            if (swordEquipped) {
                temporaryDamageBoost = 20;
                System.out.println("Daño temporal aumentado a " + (baseDamage + equippedDamage + temporaryDamageBoost));
            }
        }

        public boolean isSwordEquipped() {
            return swordEquipped;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getHealth() {
            return health;
        }

        public int getEnemiesDefeated() {
            return enemiesDefeated;
        }

        public String getInventory() {
            return String.join(", ", inventory);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, 50, 50);
        }

        public Image getSprite() {
            return sprite;
        }

        public int getDamage() {
            return baseDamage + equippedDamage + temporaryDamageBoost;
        }

        public int getAttackAngle() {
            return attackAngle;
        }

        public void addMission(Mission mission) {
            missions.add(mission);
        }

        public List<Mission> getMissions() {
            return missions;
        }

        public void drawSword(Graphics g) {
            if (swordEquipped) {
                int swordX = x + 25;
                int swordY = y + 25;

                Graphics2D g2d = (Graphics2D) g.create();
                g2d.rotate(Math.toRadians(attackAngle), swordX, swordY);
                g2d.drawImage(swordSprite, swordX - 25, swordY - 25, 50, 50, null);
                g2d.dispose();
            }
        }
    }

    // Clase Enemy (base)
    public static abstract class Enemy {
        private int x, y;
        private int speed;
        private int health;
        private Player target;
        private Image sprite;

        public Enemy(int x, int y, Player target, String spritePath) {
            this.x = x;
            this.y = y;
            this.speed = 2;
            this.health = 50;
            this.target = target;
            try {
                this.sprite = new ImageIcon(getClass().getResource(spritePath)).getImage();
                System.out.println("Sprite del enemigo cargado correctamente: " + spritePath);
            } catch (Exception e) {
                System.out.println("Error al cargar el sprite del enemigo (" + spritePath + "): " + e.getMessage());
            }
        }

        public void update() {
            if (isAlive() && isPlayerNear()) {
                moveTowardsPlayer();
            }
        }

        private boolean isPlayerNear() {
            int distance = (int) Math.sqrt(Math.pow(target.getX() - x, 2) + Math.pow(target.getY() - y, 2));
            return distance < 200;
        }

        private void moveTowardsPlayer() {
            if (x < target.getX()) {
                x += speed;
            } else if (x > target.getX())
                            } else if (x > target.getX()) {
                x -= speed;
            }

            if (y < target.getY()) {
                y += speed;
            } else if (y > target.getY()) {
                y -= speed;
            }
        }

        public void takeDamage(int damage) {
            health -= damage;
        }

        public boolean isAlive() {
            return health > 0;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, 50, 50);
        }

        public Image getSprite() {
            return sprite;
        }

        public abstract int getDamage();
    }

    // Clase Goblin
    public static class Goblin extends Enemy {
        public Goblin(int x, int y, Player target) {
            super(x, y, target, "goblin.png");
        }

        @Override
        public int getDamage() {
            return 10;
        }
    }

    // Clase Orc
    public static class Orc extends Enemy {
        public Orc(int x, int y, Player target) {
            super(x, y, target, "orc.png");
        }

        @Override
        public int getDamage() {
            return 15;
        }
    }

    // Clase Dragon
    public static class Dragon extends Enemy {
        public Dragon(int x, int y, Player target) {
            super(x, y, target, "dragon.png");
        }

        @Override
        public int getDamage() {
            return 20;
        }
    }

    // Clase Item
    public static class Item {
        private int x, y;
        private String name;
        private boolean collected;
        private Image sprite;

        public Item(int x, int y, String name) {
            this.x = x;
            this.y = y;
            this.name = name;
            this.collected = false;
            try {
                // Cargar la imagen correspondiente según el nombre del objeto
                if (name.equals("Espada")) {
                    this.sprite = new ImageIcon(getClass().getResource("espada.png")).getImage();
                } else if (name.equals("Tesoro")) {
                    this.sprite = new ImageIcon(getClass().getResource("tesoro.png")).getImage();
                } else if (name.equals("Llave")) {
                    this.sprite = new ImageIcon(getClass().getResource("llave.png")).getImage();
                } else {
                    this.sprite = new ImageIcon(getClass().getResource("item.png")).getImage();
                }
                System.out.println("Sprite del objeto cargado correctamente: " + name);
            } catch (Exception e) {
                System.out.println("Error al cargar el sprite del objeto: " + e.getMessage());
            }
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getName() {
            return name;
        }

        public boolean isCollected() {
            return collected;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, 30, 30);
        }

        public Image getSprite() {
            return sprite;
        }
    }

    // Clase NPC
    public static class NPC {
        private int x, y;
        private String dialogue;
        private Image sprite;
        private List<Mission> missions; // Misiones que el NPC puede dar

        public NPC(int x, int y, String dialogue, List<Mission> missions) {
            this.x = x;
            this.y = y;
            this.dialogue = dialogue;
            this.missions = missions;
            try {
                this.sprite = new ImageIcon(getClass().getResource("npc.png")).getImage();
                System.out.println("Sprite del NPC cargado correctamente.");
            } catch (Exception e) {
                System.out.println("Error al cargar el sprite del NPC: " + e.getMessage());
            }
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getDialogue() {
            return dialogue;
        }

        public Image getSprite() {
            return sprite;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, 50, 50);
        }

        public List<Mission> getMissions() {
            return missions;
        }

        // Método para mostrar el menú de interacción
        public void interact(Player player) {
            String[] options = {"Aceptar misión", "Hablar", "Salir"};
            int choice = JOptionPane.showOptionDialog(null, dialogue, "NPC", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0 && !missions.isEmpty()) {
                Mission mission = missions.get(0); // Dar la primera misión disponible
                player.addMission(mission);
                missions.remove(mission); // Eliminar la misión de la lista del NPC
                JOptionPane.showMessageDialog(null, "Has aceptado la misión: " + mission.getDescription());
            } else if (choice == 1) {
                JOptionPane.showMessageDialog(null, dialogue);
            }
        }
    }

    // Clase Mission
    public static class Mission {
        private String description;
        private int target;
        private boolean completed;

        public Mission(String description, int target) {
            this.description = description;
            this.target = target;
            this.completed = false;
        }

        public String getDescription() {
            return description;
        }

        public int getTarget() {
            return target;
        }

        public String getProgress() {
            return completed ? "Completada" : "En progreso";
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        // Método para verificar el progreso de la misión
        public void checkProgress(Player player) {
            if (description.equals("Derrota a 3 enemigos") && player.getEnemiesDefeated() >= target) {
                completed = true;
            }
            if (description.equals("Encuentra la llave perdida") && player.getInventory().contains("Llave")) {
                completed = true;
            }
            if (description.equals("Encuentra el tesoro") && player.getInventory().contains("Tesoro")) {
                completed = true;
            }
        }
    }
}