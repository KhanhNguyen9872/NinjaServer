
package ninja.server;

public class ItemMap
{
    protected short itemMapID;
    protected Item item;
    protected int playerId;
    protected long timeRemove;
    protected short x;
    protected short y;
    
    protected ItemMap(final Item item, final int playerId, final int timeRemove, final short x, final short y) {
        this.item = null;
        this.playerId = 0;
        this.timeRemove = -1L;
        this.item = item;
        this.playerId = playerId;
        this.timeRemove = timeRemove + System.currentTimeMillis();
        this.x = x;
        this.y = y;
    }
}
