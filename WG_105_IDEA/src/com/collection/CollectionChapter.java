package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionChapter {
    private HashMap<Integer, Chapter> chapterHM = new HashMap<>();

    // Constructor
    public CollectionChapter() {
        Chapter objChapter01 = new Chapter("The Broken World");
        addChapterHM(1, objChapter01);

        Chapter objChapter02 = new Chapter("Pursuit by Time");
        addChapterHM(2, objChapter02);

        Chapter objChapter03 = new Chapter("Into Forest");
        addChapterHM(3, objChapter03);

        Chapter objChapter04 = new Chapter("Uphill");
        addChapterHM(4, objChapter04);

        Chapter objChapter05 = new Chapter("The White Gate");
        addChapterHM(5, objChapter05);
    }

    // Getter & Setter
    public HashMap<Integer, Chapter> getChapterHM() {
        return chapterHM;
    }

    public void setChapterHM(HashMap<Integer, Chapter> vChapterHM) {
        this.chapterHM = vChapterHM;
    }

    // Methods
    public void printChapter() {
        chapterHM.forEach((k, v) -> System.out.println("[" + k + "] " + v.getName()));
    }

    public void addChapterHM(Integer chapterID, Chapter objChapter) {
        chapterHM.put(chapterID, objChapter);
    }

    public Chapter takeChapterHM(Integer chapterID) {
        return getChapterHM().get(chapterID);
    }

}
