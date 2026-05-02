package singleton;

public final class DatabaseConnectionPool {

    private static volatile DatabaseConnectionPool instance;
    private boolean active;

    private DatabaseConnectionPool() {
        ConfigurationManager config = ConfigurationManager.getInstance();
        this.active = true;
        System.out.println("[DatabaseConnectionPool] Kết nối CSDL thành công!");
        System.out.println("[DatabaseConnectionPool] URL: " + config.getDbUrl());
        System.out.println("[DatabaseConnectionPool] Pool Size: " + config.getPoolSize());
    }

    public static DatabaseConnectionPool getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionPool.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionPool();
                }
            }
        }
        return instance;
    }

    public boolean isActive() {
        return active;
    }

    public void closePool() {
        this.active = false;
        System.out.println("[DatabaseConnectionPool] Đã đóng connection pool");
    }
}
