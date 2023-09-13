package com.patterns.command;

public class DeleteCommand implements Command{
    private Database db;

    public DeleteCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute() {
        db.delete();
    }
}
