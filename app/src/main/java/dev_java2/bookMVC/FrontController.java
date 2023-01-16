package dev_java2.bookMVC;

public class FrontController {
    public static Object getController(String gubun) {
    // public static FrontController getController(String gubun) {
        Object obj = null; //BookController or BoardController
        // FrontController obj = null;
        if ("bookMgr".equals(gubun)) {
            obj = new BookController();
        }
        else if ("boardMgr".equals(gubun)) {
            obj = new BoardController();
        }
        return obj;
    }
}
