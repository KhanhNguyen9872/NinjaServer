
package ninja.server;

import java.sql.SQLException;
import io.MySQL;
import ninja.template.ItemTemplate;
import ninja.template.SkillTemplate;
import java.util.HashMap;
import ninja.template.ItemOptionTemplate;
import ninja.template.SkillOptionTemplate;
import ninja.template.MapTemplate;
import ninja.template.TaskTemplate;

public class GameScr
{
    protected static int post;
    private static String host;
    private static String mysql_host;
    private static String mysql_database;
    private static String mysql_user;
    private static String mysql_pass;
    protected static byte vData;
    protected static byte vMap;
    protected static byte vSkill;
    protected static byte vItem;
    protected static byte vEvent;
    protected static byte vEvent_1;
    protected static byte max_CreateChar;
    protected static int max_upLevel;
    protected static byte max_Friend;
    protected static byte max_Enemies;
    public static byte[][] tasks;
    public static byte[][] mapTasks;
    protected static NClass[] nClasss;
    protected static Skill[] skills;
    protected static long[] exps;
    protected static int[] crystals;
    protected static int[] upClothe;
    protected static int[] upAdorn;
    public static int[] upWeapon;
    public static int[] coinUpCrystals;
    public static int[] coinUpClothes;
    public static int[] coinUpAdorns;
    public static int[] coinUpWeapons;
    public static int[] maxPercents;
    public static int[] goldUps;
    public static int[] coinGotngoc;
    protected static TaskTemplate[] taskTemplates;
    protected static MapTemplate[] mapTemplates;
    public static SkillOptionTemplate[] sOptionTemplates;
    public static ItemOptionTemplate[] iOptionTemplates;
    protected static HashMap<Byte, Item[]> itemStores;
    protected static SkillTemplate[] skillTemplates;
    protected static ItemTemplate[] itemTemplates;
    
    private static void loadConfigFile() {
        final byte[] ab = NinjaUtil.getFile("ninja.conf");
        if (ab == null) {
            System.out.println("Config file not found!");
            System.exit(0);
        }
        final String data = new String(ab);
        final HashMap<String, String> configMap = new HashMap<String, String>();
        final StringBuilder sbd = new StringBuilder();
        boolean bo = false;
        for (int i = 0; i <= data.length(); ++i) {
            final char es;
            if (i == data.length() || (es = data.charAt(i)) == '\n') {
                bo = false;
                final String sbf = sbd.toString().trim();
                if (sbf != null && !sbf.equals("") && sbf.charAt(0) != '#') {
                    final int j = sbf.indexOf(58);
                    if (j > 0) {
                        final String key = sbf.substring(0, j).trim();
                        final String value = sbf.substring(j + 1).trim();
                        configMap.put(key, value);
                    }
                }
                sbd.setLength(0);
            }
            else {
                if (es == '#') {
                    bo = true;
                }
                if (!bo) {
                    sbd.append(es);
                }
            }
        }
        if (configMap.containsKey("debug")) {
            Util.setDebug(Boolean.parseBoolean(configMap.get("debug")));
        }
        else {
            Util.setDebug(false);
        }
        if (configMap.containsKey("host")) {
            GameScr.host = configMap.get("host");
        }
        else {
            GameScr.host = "localhost";
        }
        if (configMap.containsKey("post")) {
            GameScr.post = Short.parseShort(configMap.get("post"));
        }
        else {
            GameScr.post = 14444;
        }
        if (configMap.containsKey("mysql-host")) {
            GameScr.mysql_host = configMap.get("mysql-host");
        }
        else {
            GameScr.mysql_host = "localhost";
        }
        if (configMap.containsKey("mysql-user")) {
            GameScr.mysql_user = configMap.get("mysql-user");
        }
        else {
            GameScr.mysql_user = "root";
        }
        if (configMap.containsKey("mysql-password")) {
            GameScr.mysql_pass = configMap.get("mysql-password");
        }
        else {
            GameScr.mysql_pass = "";
        }
        if (configMap.containsKey("mysql-database")) {
            GameScr.mysql_database = configMap.get("mysql-database");
        }
        else {
            GameScr.mysql_database = "ninja";
        }
        if (configMap.containsKey("version-Data")) {
            GameScr.vData = Byte.parseByte(configMap.get("version-Data"));
        }
        else {
            GameScr.vData = 1;
        }
        if (configMap.containsKey("version-Map")) {
            GameScr.vMap = Byte.parseByte(configMap.get("version-Map"));
        }
        else {
            GameScr.vMap = 1;
        }
        if (configMap.containsKey("version-Skill")) {
            GameScr.vSkill = Byte.parseByte(configMap.get("version-Skill"));
        }
        else {
            GameScr.vSkill = 1;
        }
        if (configMap.containsKey("version-Item")) {
            GameScr.vItem = Byte.parseByte(configMap.get("version-Item"));
        }
        else {
            GameScr.vItem = 1;
        }
        if (configMap.containsKey("version-Event")) {
            GameScr.vEvent = Byte.parseByte(configMap.get("version-Event"));
        }
        else {
            GameScr.vEvent = 0;
        }
        if (configMap.containsKey("version-Event_1")) {
            GameScr.vEvent_1 = Byte.parseByte(configMap.get("version-Event_1"));
        }
        else {
            GameScr.vEvent_1 = 0;
        }
        if (configMap.containsKey("max-taoNhanVat")) {
            GameScr.max_CreateChar = Byte.parseByte(configMap.get("max-taoNhanVat"));
        }
        else {
            GameScr.max_CreateChar = 3;
        }
        if (configMap.containsKey("max-upLevel")) {
            GameScr.max_upLevel = Integer.parseInt(configMap.get("max-upLevel"));
        }
        else {
            GameScr.max_upLevel = 130;
        }
        if (configMap.containsKey("max-Friend")) {
            GameScr.max_Friend = Byte.parseByte(configMap.get("max-Friend"));
        }
        else {
            GameScr.max_Friend = 50;
        }
        if (configMap.containsKey("max-Enemies")) {
            GameScr.max_Enemies = Byte.parseByte(configMap.get("max-Enemies"));
        }
        else {
            GameScr.max_Enemies = 20;
        }
    }
    
    protected static void init() {
        loadConfigFile();
        try {
            MySQL.createConnection(0, GameScr.mysql_host, "khanh5", GameScr.mysql_user, GameScr.mysql_pass);
            MySQL.createConnection(1, GameScr.mysql_host, GameScr.mysql_database, GameScr.mysql_user, GameScr.mysql_pass);
            Init.init();
            final MySQL mySQL = new MySQL(1);
            mySQL.stat.executeUpdate("UPDATE `user` SET `online` = 0;");
            mySQL.stat.executeUpdate("UPDATE `player` SET `caveId` = -1;");
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    protected static int getMaxpPoint(final int level) {
        if (level < 70) {
            return 10;
        }
        if (level < 80) {
            return 20;
        }
        if (level < 90) {
            return 30;
        }
        return 50;
    }
    
    protected static long getMaxEXP(final int level) {
        long num = 0L;
        for (int i = 0; i < level; ++i) {
            num += GameScr.exps[i];
        }
        return num;
    }
    
    protected static long[] getLevelExp(final long exp) {
        long num;
        int i;
        for (num = exp, i = 0; i < GameScr.exps.length && num >= GameScr.exps[i]; num -= GameScr.exps[i], ++i) {}
        return new long[] { i, num };
    }
    
    public static void setLevel_Exp(final Char _char, final long exp, final boolean value) {
        final long[] levelExp = getLevelExp(exp);
        if (value) {
            _char.cLevel = (int)levelExp[0];
        }
        _char.cExpR = levelExp[1];
    }
    
    protected static synchronized void chatKTG(final Char _char, final String text) {
        try {
            if (_char.user.luong < 5) {
                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 8));
                return;
            }
            if (_char.user.secondKTG > System.currentTimeMillis()) {
                GameCanvas.startOKDlg(_char.user.session, String.format(Text.get(0, 7), Util.getStrTime(_char.user.secondKTG - System.currentTimeMillis())));
                return;
            }
            _char.user.secondKTG = System.currentTimeMillis() + 5000L;
            _char.user.player.upGold(-5L, (byte)1);
            Client.chatServer(_char.cName, text);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static byte getLevelSpeed(final int level) {
        if (level >= 40) {
            return 3;
        }
        if (level >= 25) {
            return 2;
        }
        if (level >= 10) {
            return 1;
        }
        return 0;
    }
    
    protected static short resetpPoint(final byte nClass, final byte index) {
        if (nClass == 2 || nClass == 4 || nClass == 6) {
            switch (index) {
                case 0: {
                    return 5;
                }
                case 1: {
                    return 5;
                }
                case 2: {
                    return 10;
                }
                case 3: {
                    return 10;
                }
            }
        }
        else {
            switch (index) {
                case 0: {
                    return 15;
                }
                case 1: {
                    return 5;
                }
                case 2: {
                    return 5;
                }
                case 3: {
                    return 5;
                }
            }
        }
        return 0;
    }
    
    protected static int EXPMobX(final short level) {
        if (level >= 100) {
            return 2;
        }
        if (level >= 90) {
            return 3;
        }
        if (level >= 80) {
            return 4;
        }
        if (level >= 70) {
            return 3;
        }
        if (level >= 40) {
            return 2;
        }
        return 1;
    }
    
    static {
        GameScr.coinGotngoc = new int[] { 0, 5000, 40000, 135000, 320000, 625000, 1080000, 1715000, 2560000, 3645000, 5000000 };
    }
}
