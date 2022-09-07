package ninja.server;

import java.util.HashMap;
import java.util.ArrayList;

public class ClanManor
{
    protected int manorId;
    protected Map[] map;
    protected Clan clan;
    protected int timeLength;
    protected ArrayList<Char> charInManor;
    protected ArrayList<Integer> playerIdJoin;
    protected final Object LOCK_LOCAL;
    protected static final ArrayList<ClanManor> arrManor;
    protected static final HashMap<String, ClanManor> manor_name;
    protected static final int setTimeOpen = 600;
    protected static final int setTimeStart = 3600;
    protected static final byte MAP_LOCAL = 80;
    protected static short[] arrMapId;
    protected static int baseId;
    protected static final Object LOCK;
    
    protected ClanManor(final int clanId) {
        this.map = null;
        this.clan = null;
        this.charInManor = new ArrayList<Char>();
        this.playerIdJoin = new ArrayList<Integer>();
        this.LOCK_LOCAL = new Object();
    }
    
    protected ClanManor() {
        this.map = null;
        this.clan = null;
        this.charInManor = new ArrayList<Char>();
        this.playerIdJoin = new ArrayList<Integer>();
        this.LOCK_LOCAL = new Object();
    }
    
    protected static void createManor(final Char _char, final Clan clan) {
    }
    
    protected static Map getMap(final ClanManor manor, final short mapId) {
        for (byte i = 0; i < manor.map.length; ++i) {
            if (manor.map[i].template.mapID == mapId) {
                return manor.map[i];
            }
        }
        return null;
    }
    
    static {
        arrManor = new ArrayList<ClanManor>();
        manor_name = new HashMap<String, ClanManor>();
        ClanManor.arrMapId = new short[] { 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
        ClanManor.baseId = 0;
        LOCK = new Object();
    }
}
