package com.itp.myapplication;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Todos implements Serializable {
    private int todoId;
    private String todoIcerik;
    private boolean todoComplete;
    private String whenCreated;

    public Todos() {
    }

    public Todos(int todoId, String todoIcerik, boolean todoComplete,String whenCreated) {
        this.todoId = todoId;
        this.todoIcerik = todoIcerik;
        this.todoComplete = todoComplete;
        this.whenCreated=whenCreated;   }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTodoIcerik() {
        return todoIcerik;
    }

    public void setTodoIcerik(String todoIcerik) {
        this.todoIcerik = todoIcerik;
    }

    public boolean isTodoComplete() {
        return todoComplete;
    }

    public void setTodoComplete(boolean todoComplete) {
        this.todoComplete = todoComplete;
    }

    public String getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(String whenCreated) {
        this.whenCreated = whenCreated;
    }
}
