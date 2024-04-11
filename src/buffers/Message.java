package buffers;

public class Message<T> {
    private T content;
    private Writer sender;
    public Message(T content, Writer sender) {
        this.content = content;
        this.sender = sender;
    }
    public T getContent() { return content; }
    public Writer getSender() { return sender; }
    public String toString() {
        return "-> " + content + " from " + sender.getName();
    }
}