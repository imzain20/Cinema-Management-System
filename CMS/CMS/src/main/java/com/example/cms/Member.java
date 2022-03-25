package com.example.cms;

public class Member {

    private int m_id;
    private String m_name;
    private String m_email;
    private String status;
    public Member()
    {
       m_id=0;
       m_name="";
       m_email="";
       status="";
    }

    //setters
    public void setid(int wid)
    {
        m_id=wid;
    }
    public void setpname(String p_name)
    {
        m_name=p_name;
    }
    public void setmemail(String p_email)
    {
        m_email=m_email;
    }
    //getters
    public int getid()
    {
        return m_id;
    }
    public String getpname()
    {
        return getpname();
    }

}
