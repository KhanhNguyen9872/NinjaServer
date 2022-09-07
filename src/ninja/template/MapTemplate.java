
package ninja.template;

import ninja.server.ItemTree;

public class MapTemplate
{
    public short mapID;
    public byte mapVersion;
    public String mapName;
    public String mapDescription;
    protected char[] mapData;
    protected short mapH;
    protected short mapW;
    public short[] WminX;
    public short[] WminY;
    public short[] WmaxX;
    public short[] WmaxY;
    public short[] WgoX;
    public short[] WgoY;
    public short[] WmapID;
    public short[] itemMap;
    public ItemTree[] ItemTreeFront;
    public ItemTree[] ItemTreeBehind;
    public ItemTree[] ItemTreeBetwen;
    public byte[] npcType;
    public short[] npcX;
    public short[] npcY;
    public byte[] npcID;
    protected short sumMob;
    public int[] mobID;
    public short[] mobLevel;
    public short[] mobX;
    public short[] mobY;
    public byte[] mobStatus;
    public byte[] moblevelBoss;
    public int[] mobRefreshTime;
    public byte tileID;
    public byte bgID;
    public byte typeMap;
    public byte numZone;
    public short goX;
    public short goY;
}
