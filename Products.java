package mikemeat.admin.moodtracker;


public class Products {

    private int _id; //must be _id for primary key
    private String _productname;

    public Products(){  //empty constructor
    }

    public Products(String productname)
    {
        this._productname = productname;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }



    public int get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }


}
