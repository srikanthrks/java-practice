package hackerrank;

/**
 * Created by srikanth.kannan on 5/19/16.
 */
public class TestAbstractClass {
    public static void main(String args[]){
        MyBook myBook = new MyBook();
        myBook.setTitle("A tale of two cities");
        System.out.println("title = " + myBook.getTitle());

    }

    private static class MyBook extends AbstractClassBook {
        @Override
        void setTitle(String title) {
            super.title = title;
        }
    }
}

