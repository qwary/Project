/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.project.utils;

/**
 *
 * @author Domas
 */
public class Form {
    private String title, date;
    private User user;
    private FilledData<Object>[] data;
    private Field[] columns;
    public Form(String name, User user, String date){
        this.title = name;
        this.user = user;
        this.date = date;
    }
    public String getTitle(){
        return title;
    }
    public User getUser(){
        return user;
    }
    public String getDate(){
        return date;
    }
    public void setFields(Field[] columns){
        this.columns = columns;
    }
    public Field[] getFields(){
        return columns;
    }
    public void setData(FilledData<Object>[] data){
        this.data = data;
    }
    public FilledData<Object>[] getData(){
        return data;
    }
    @Override
    public String toString() {
        return title; 
    }
    
}
