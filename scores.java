package mikemeat.admin.moodtracker;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class scores {

    private int _id; //must be _id for primary key
    private String _scores;
    private String _cause;
    private String _category;
    private String _date;

    public scores() {
    }

//
//    public scores(String _scores) {
//        this._scores = _scores;
//        this._scores = _cause;
//        this._scores =  _category;
//    }


    public scores(String _scores, String _cause, String _category) {
        this._scores = _scores;
        this._cause = _cause;
        this._category = _category;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        _date = dateFormat.format(date);
        this._date = _date;
        // this._scores =  _datetime;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_scores() {
        return _scores;
    }

    public void set_scores(String _scores) {
        this._scores = _scores;
    }

    public String get_cause() {
        return _cause;
    }

    public void set_cause(String _cause) {
        this._cause = _cause;
    }

    public String get_category() {
        return _category;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public String get_date() {
        return _date;
    }

//    public void set_date(String _date) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        _date = dateFormat.format(date);
//        this._date = _date;
//    }
}