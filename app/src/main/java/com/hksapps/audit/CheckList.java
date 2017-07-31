package com.hksapps.audit;

/**
 * Created by Administrator on 7/31/2017.
 */

public class CheckList {
    //private variables
    int id;
    String checklist, yes, no, remarks;

    public CheckList(){

    }

    public CheckList(int id,String checklist,String yes ,String no , String remarks){

        this.id = id;
        this.checklist = checklist;
        this.yes = yes;
        this.no = no;
        this.remarks = remarks;
    }

    public CheckList(String checklist){


        this.checklist = checklist;

    }

    // getting ID
    public int getId(){
        return this.id;
    }

    // setting id
    public void setId(int id){
        this.id = id;
    }


    public String getChecklist(){
        return this.checklist;
    }


    public void setChecklist(String Checklist){
        this.checklist = Checklist;
    }



    public String getYes(){
        return this.yes;
    }


    public void setYes(String Yes){
        this.yes = Yes;
    }


    public String getNo(){
        return this.no;
    }


    public void setNo(String no){
        this.no = no;
    }


    public String getRemarks(){
        return this.remarks;
    }


    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
}
