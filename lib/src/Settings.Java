public class Settings {
    private static Settings instace;
    public enum supportedDB {
        MySQL,
    }
    private supportedDB dbType;

    private Settings {

    }

    public Settings getSettigns {
        if (instace == null) {
            instace = new settings();
        }
        else return instace;
    }

    public void setDBType(supportedDB dbType) {
        this.dbType = dbType;
    }

    public String getDBDriver() throws ClassNotFoundException {
        switch dbType {
            case MySQL:
                return "com.mysql.cj.jdbc.Driver";
            default:
                throw ClassNotFoundException("Unsupported database type.");
        }
    }
}