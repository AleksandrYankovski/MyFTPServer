package model.observer;

public interface Observable {

    void addObserver(Observer observer);
    void updateLog(String log);
}
