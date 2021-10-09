package com.gathco.contactcrud;

public class ModalContact {
    String _id, _name, _number;

    public ModalContact(String id, String name, String number) {
        this._id = id;
        this._name = name;
        this._number = number;
    }

    public ModalContact(){

    }

    public void set_id(String id){
        this._id = id;
    }

    public String get_id(){
        return this._id;
    }

    public void set_name(String name){
        this._name = name;
    }

    public String get_name(){
        return this._name;
    }

    public void set_number(String number){
        this._number = number;
    }

    public String get_number(){
        return this._number;
    }
}
