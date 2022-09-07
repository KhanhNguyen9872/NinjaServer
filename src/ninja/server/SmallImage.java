
package ninja.server;

import io.Message;

public class SmallImage
{
    protected static void reciveImage(final User user, final int id) {
        Message msg = null;
        try {
            byte zoon = user.session.zoomLevel;
            if (zoon < 1) {
                zoon = 1;
            }
            else if (zoon > 4) {
                zoon = 4;
            }
            final byte[] ab = NinjaUtil.getFile("assets/x" + zoon + "/icon/" + id + ".png");
            if (ab != null) {
                msg = Service.messageNotMap((byte)(-115));
                msg.writer().writeInt(id);
                NinjaUtil.writeByteArray(msg, ab);
                user.session.sendMessage(msg);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }
}
