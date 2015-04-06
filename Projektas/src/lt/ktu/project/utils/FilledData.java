/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.ktu.project.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dominykas
 */
public class FilledData<E> extends ArrayList<E> implements List<E>{
    private final User user;
    private final Date date;
    public FilledData(User user, Date date){
        super();
        this.user = user;
        this.date = date;
    }
    public FilledData(User user, Date date, E[] data){
        super();
        this.user = user;
        this.date = date;
        addAll(Arrays.asList(data));
    }
    public Date getDate(){
        return date;
    }
    public User getUser(){
        return user;
    }
}
