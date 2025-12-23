package codefinity.Task;

import java.util.Deque;

public class BrowserHistoryImpl implements  BrowserHistory {

    private Deque<String> backStack;
    private Deque<String> forwardStack;
    private String currentURL;

    public BrowserHistoryImpl(Deque<String> backStack, Deque<String> forwardStack, String initialUrl){
        this.backStack = backStack;
        this.forwardStack = forwardStack;
        this.currentURL = initialUrl;
    }


    @Override
    public void visitPage(String url) {
        backStack.addLast(currentURL);
        forwardStack.clear();
        currentURL = url;
    }

    @Override
    public void goBack() {
        if(!backStack.isEmpty())
        {
            forwardStack.addLast(currentURL);
            currentURL = backStack.getLast();
        }
        else{
            System.out.println("Already at last page.");
        }

    }

    @Override
    public void goForward() {
        if(!forwardStack.isEmpty()){
            backStack.addLast(currentURL);
            currentURL = forwardStack.getLast();
        }
        else{
            System.out.println("Already at first page.");
        }


    }

    @Override
    public String getCurrentPage() {
        return currentURL;
    }
}
