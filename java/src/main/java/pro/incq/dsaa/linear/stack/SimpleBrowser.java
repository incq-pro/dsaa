package pro.incq.dsaa.linear.stack;

/**
 * @author yun.516@gmail.com
 */
public class SimpleBrowser {
    private ArrayStack backStack;
    private ArrayStack forwardStack;

    public SimpleBrowser() {
        backStack = new ArrayStack(10);
        forwardStack = new ArrayStack(10);
    }

    public void open(String url) {
        backStack.push(url);
        while (forwardStack.pop() != null) {
        }
    }

    public void goBack() {
        String url = backStack.pop();
        if (url != null) {
            forwardStack.push(url);
        }
    }

    public void goForward() {
        String url = forwardStack.pop();
        if (url != null) {
            backStack.push(url);
        }
    }

    public String current() {
        return backStack.head();
    }
}
