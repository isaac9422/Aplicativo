/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptokey;

public class CryptoKey {

    public String generarClaveEncriptada(String llave, boolean desem) {
        String rpta = "";
        String caralf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String cardes = "KEF9BCMTS3AYG75V01IH8PU6LXQRJ4OZWN2D";
        String carkey1 = cardes;
        String carkey2 = cardes;
        String carkey3 = cardes;
        String carkey4 = cardes;
        int npos1 = caralf.indexOf(llave.substring(0, 1));
        int npos2 = caralf.indexOf(llave.substring(1, 2));
        int npos3 = caralf.indexOf(llave.substring(2, 3));
        int npos4 = caralf.indexOf(llave.substring(3, 4));
        if (npos1 > 0) {
            carkey1 = carkey1.substring(npos1 - 1) + carkey1.substring(0, npos1);
        }
        if (npos2 > 0) {
            carkey2 = carkey2.substring(npos2 - 1) + carkey2.substring(0, npos2);
        }
        if (npos3 > 0) {
            carkey3 = carkey3.substring(npos3 - 1) + carkey3.substring(0, npos3);
        }
        if (npos4 > 0) {
            carkey4 = carkey4.substring(npos4 - 1) + carkey4.substring(0, npos4);
        }
        if (desem) {
//            rpta = kriptar(cla_, .T.);
//            rpta = CHRTRAN(rpta, carkey4, caralf);
//            rpta = CHRTRAN(rpta, carkey3, caralf);
//            rpta = CHRTRAN(rpta, carkey2, caralf);
//            rpta = CHRTRAN(rpta, carkey1, caralf);
//            rpta = CHRTRAN(rpta, cardes, caralf);
        } else {
//            rpta = CHRTRAN(cla_, caralf, cardes);
//            rpta = CHRTRAN(rpta, caralf, carkey1);
//            rpta = CHRTRAN(rpta, caralf, carkey2);
//            rpta = CHRTRAN(rpta, caralf, carkey3);
//            rpta = CHRTRAN(rpta, caralf, carkey4);
//            RETURN kriptar(rpta);
        }
        return rpta;
    }

    public static void main(String[] args) {
        // TODO code application logic here

    }

}
