package singleton;

import java.util.Properties;

public final class ConfigurationManager {

    private static volatile ConfigurationManager instance;
    private final Properties properties;

    private ConfigurationManager() {
        this.properties = new Properties();
        setDefaultConfiguration();
        System.out.println("[ConfigurationManager] Singleton instance được khởi tạo");
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    private void setDefaultConfiguration() {
        properties.setProperty("db.host", "localhost");
        properties.setProperty("db.port", "3306");
        properties.setProperty("db.name", "bookstore_db");
        properties.setProperty("db.username", "root");
        properties.setProperty("db.password", "123456");
        properties.setProperty("db.pool.size", "10");
        properties.setProperty("app.name", "BookStore Online");
        properties.setProperty("app.version", "1.0.0");
    }

    public String getDbUrl() {
        String host = properties.getProperty("db.host");
        String port = properties.getProperty("db.port");
        String dbName = properties.getProperty("db.name");
        return "jdbc:mysql://" + host + ":" + port + "/" + dbName;
    }

    public String getDbUsername() {
        return properties.getProperty("db.username");
    }

    public String getDbPassword() {
        return properties.getProperty("db.password");
    }

    public int getPoolSize() {
        return Integer.parseInt(properties.getProperty("db.pool.size", "10"));
    }

    public String getAppName() {
        return properties.getProperty("app.name");
    }

    public String getAppVersion() {
        return properties.getProperty("app.version");
    }

    public void printConfig() {
        System.out.println("  Database URL: " + getDbUrl());
        System.out.println("  Database User: " + getDbUsername());
        System.out.println("  Pool Size: " + getPoolSize());
        System.out.println("  App: " + getAppName() + " v" + getAppVersion());
    }
}
