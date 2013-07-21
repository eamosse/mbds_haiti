/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.edu.fds.mbds.android.bibliotheque;

/**
 *
 * @author edou
 */
public enum Genre {
    MASCULIN ('M'), FEMININ('F');
    char genre; 
    Genre(char g){
    this.genre = g;
}
}
