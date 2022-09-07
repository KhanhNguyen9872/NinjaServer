
package ninja.server;

public class Friend
{
    protected String friendName;
    protected byte type;
    
    protected Friend(final String friendName, final byte type) {
        this.friendName = friendName;
        this.type = type;
    }
}
