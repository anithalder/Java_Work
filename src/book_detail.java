class book_detail {
    long price;
    String title,author,isbn;

    book_detail(long price,String title,String author,String isbn){
        this.price=price;
        this.title=title;
        this.author=author;
        this.isbn=isbn;
    }

    public void display(){
        System.out.println("Price - "+price+" | "+"Title - "+title+" | "+"Author - "+author+" | "+"ISBN - "+isbn);
    }

    public static void main(String[] args) {
        book_detail b1 = new book_detail(100,"Java","Ravi","123456");
        book_detail b2 = new book_detail(200,"C++","Ravi","123456");
        book_detail b3 = new book_detail(300,"C","Ravi","123456");
        b1.display();
        b2.display();
        b3.display();
    }
}
