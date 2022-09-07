package ninja.server;

import io.Message;
import java.util.ArrayList;

public class Client
{
    protected static int sizeClients;
    protected static final ArrayList<Session_ME> clients;
    protected static final Object LOCK;
    
    protected static void chatServer(final String whochat, final String chat) {
        try {
            final Message msg = new Message((byte)(-21));
            try {
                msg.writer().writeUTF(whochat);
                msg.writer().writeUTF(chat);
                synchronized (Client.LOCK) {
                    for (int i = 0; i < Client.clients.size(); ++i) {
                        if (Client.clients.get(i).user != null && Client.clients.get(i).user.player != null) {
                            Client.clients.get(i).sendMessage(msg);
                        }
                    }
                }
            }
            finally {
                msg.cleanup();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static void alertServer(final String str) {
        try {
            final Message msg = new Message((byte)(-25));
            try {
                msg.writer().writeUTF(str);
                synchronized (Client.LOCK) {
                    for (int i = 0; i < Client.clients.size(); ++i) {
                        if (Client.clients.get(i).user != null && Client.clients.get(i).user.player != null) {
                            Client.clients.get(i).sendMessage(msg);
                        }
                    }
                }
            }
            finally {
                msg.cleanup();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static void startOKDlgServer(final String info) {
        try {
            final Message msg = new Message((byte)(-26));
            try {
                msg.writer().writeUTF(info);
                synchronized (Client.LOCK) {
                    for (int i = 0; i < Client.clients.size(); ++i) {
                        if (Client.clients.get(i).user != null && Client.clients.get(i).user.player != null) {
                            Client.clients.get(i).sendMessage(msg);
                        }
                    }
                }
            }
            finally {
                msg.cleanup();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected static void joinClient(final Session_ME cl) {
        synchronized (Client.LOCK) {
            if (!Client.clients.contains(cl)) {
                Client.clients.add(cl);
                ++Client.sizeClients;
            }
        }
    }
    
    protected static void removeClinet(final Session_ME cl) {
        synchronized (Client.LOCK) {
            if (Client.clients.contains(cl)) {
                Client.clients.remove(cl);
                --Client.sizeClients;
                Util.log("Disconnect client: " + cl);
            }
        }
    }
    
    protected static int sizeUser() {
        int size = 0;
        synchronized (Client.LOCK) {
            for (int i = 0; i < Client.clients.size(); ++i) {
                if (Client.clients.get(i).user != null) {
                    ++size;
                }
            }
        }
        return size;
    }
    
    protected static Player getPlayer(final String cName) {
        synchronized (Client.LOCK) {
            for (int i = 0; i < Client.clients.size(); ++i) {
                if (Client.clients.get(i).user != null && Client.clients.get(i).user.player != null && Client.clients.get(i).user.player != null && Client.clients.get(i).user.player.cName.equals(cName)) {
                    return Client.clients.get(i).user.player;
                }
            }
        }
        return null;
    }
    
    protected static Player getPlayer(final int charID) {
        synchronized (Client.LOCK) {
            for (int i = 0; i < Client.clients.size(); ++i) {
                if (Client.clients.get(i).user != null && Client.clients.get(i).user.player != null && Client.clients.get(i).user.player != null && Client.clients.get(i).user.player.charID == charID) {
                    return Client.clients.get(i).user.player;
                }
            }
        }
        return null;
    }
    
    protected static User getUser(final String uname) {
        synchronized (Client.LOCK) {
            for (int i = 0; i < Client.clients.size(); ++i) {
                if (Client.clients.get(i).user != null && Client.clients.get(i).user.userName.equals(uname)) {
                    return Client.clients.get(i).user;
                }
            }
        }
        return null;
    }
    
    static {
        clients = new ArrayList<Session_ME>();
        LOCK = new Object();
    }
}
