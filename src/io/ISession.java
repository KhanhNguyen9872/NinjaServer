package io;

public interface ISession
{
    boolean isConnected();
    
    void sendMessage(final Message p0);
    
    void close();
}
