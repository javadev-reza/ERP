
import com.microservice.erp2017.util.PasswordUtil;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reza
 */
public class AuthTest {
    
    public static void main(String[]args) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        System.out.println(new PasswordUtil().encryptPassword("root"));
    }
}
