package com.patterns.command;

public class SelectCommand implements Command{
    private Database db;

    public SelectCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute() {
        db.select();
    }
}
