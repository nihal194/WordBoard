/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import static java.lang.System.in;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.ItemList;
import org.json.simple.JSONObject;


/**
 *
 * @author nihal-pt1432
 */
@WebServlet(urlPatterns = {"/Javafile"})
public class Javafile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");

        //System.out.print("I am here");
        try {
            HashMap<String,Integer> words=new HashMap<String,Integer>();
            HashMap<String,String> matchedWords=new HashMap<String,String>();
            readWords(words);
            long totalFind=0;

            JSONArray permutedWordArray=new JSONArray();
            JSONArray similarWordArray=new JSONArray();
            //ItemList matchedWords=new ItemList();
            JSONObject wordObj=new JSONObject();
            JSONArray matchedArrayJSON=new JSONArray();
            //JSONObject matchedWordJSON=new JSONObject();
            
            String s=request.getParameter("inputStr");
            int page=Integer.parseInt(request.getParameter("page"));
            System.out.println(s);
            //wordObj.put("searchString",s);
            int count;
            count=page*10;
            //System.out.println("Page No "+page);
            //String count=request.getParameter("count");
            //String inputStr=request.getParameter("inputStr");
           // String tem=s.substring(s.indexOf(" ")+1);
           // s=s.substring(0,s.lastIndexOf(" "));
            //int count=Integer.parseInt(tem);
            
           // StringBuilder webpage_Msg=new StringBuilder("");
           // if(s.equals("!"))
           // {
           //       call_Webpage(request,response,wordObj);
          //  }
           // else
           // {
                
                totalFind=findMatchedWords(s,words,matchedWords,matchedArrayJSON,count);
                //boolean morePages=(offset+count)>totalFind;
                wordObj.put("matchedArrayJSON",matchedArrayJSON);
                wordObj.put("totalFind",totalFind);
                
                boolean exist=findWord(s,words);
                
                if(exist)
                {
                    /*
                    boolean flag=addWordInDB(s);

                    if(flag)
                    {
                        webpage_Msg.append("<div class=\"alert alert-success\" align=\"center\">Stored in DB!! :) :)<button id=\"hi\" type=\"button\" class=\"close\" aria-label=\"Close\">\n" +
"  <span aria-hidden=\"true\">&times;</span>\n" +
"</button></div>");
                    }
                    else
                    {
                        webpage_Msg.append("<div class=\"alert alert-warning\" align=\"center\">Word Aready stored in DB!!<button id=\"hi\" type=\"button\" class=\"close\" aria-label=\"Close\">\n" +
"  <span aria-hidden=\"true\">&times;</span>\n" +
"</button></div>");
                    }
                }
                else
                {
                    webpage_Msg.append("<div class=\"alert alert-warning\" align=\"center\">Bad Word!!<button id=\"hi\" type=\"button\" class=\"close\" aria-label=\"Close\">\n" +
"  <span aria-hidden=\"true\">&times;</span>\n" +
"</button></div>");
                    */
                    if(s.length()<11)
                    {
                        //webpage_Msg.append("<div class=\"alert alert-success\"><u><strong>Suggeted words:</strong></u> ");
                        //sug1.append("[");
                        permutedWordArray.add(s);
                        next_perm(s.toCharArray(),0,words,permutedWordArray);
                        wordObj.put("permutedWordArray",permutedWordArray);
                        //if(sug1.length()>0)
                          //  sug1.deleteCharAt(sug1.length()-1);
                        //sug1.append("]");
                        //webpage_Msg.append("</div");
                    }
                        
                    //webpage_Msg.append("<div class=\"alert alert-success\"><br><u><strong>More Suggestions:</strong></u> ");
                    printSuggested2(s,words,similarWordArray);
                    wordObj.put("similarWordArray",similarWordArray);
                   // if(sug2.length()>0)
                    //sug2.deleteCharAt(sug2.length()-1);
                    //webpage_Msg.append("</div>");
                }
               
           // }

            call_Webpage(request,response,wordObj);
           // webpage_Msg.delete(0,webpage_Msg.length());
        }finally {
           //     out.close();
            } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    void readWords(HashMap<String,Integer> words)
    {
        try{
            Scanner me=new Scanner(new File("E:/Sample Projects/ValidateWords/words.txt"));
            String word;
            while(me.hasNext())
            {
                word=me.next();
                words.put(word,word.length());
            }
        }catch(Exception e)
        {
            
        }
        /*
        String fname="E:/Sample Projects/ValidateWords/words.txt";
        Path p1=Paths.get(fname);
        try
        {
         words = Files.readAllLines(p1);
        }catch(Exception e)
        {
            
        }
        */
    }
    
    
    void call_Webpage(HttpServletRequest request, HttpServletResponse response,JSONObject wordObj)
    {
       // request.setAttribute("msg", webpage_Msg);
    //    request.setAttribute("sug1",sug1);
      //  request.setAttribute("sug2",sug2);
        //request.setAttribute("wordObj",wordObj);
        //System.out.print("I am here in response function");
        try{
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(String.valueOf(wordObj));
        //getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }catch(Exception e)
        {
            
        }
    }
    
   
    boolean findWord(String s,HashMap words)
    {
        /*
        String fname="E:/Sample Projects/ValidateWords/WordsList/";
        fname+=s.charAt(0)+" Words.txt";
        Path p1=Paths.get(fname);
        try
        {
        List<String> lines = Files.readAllLines(p1);
        if(Collections.binarySearch(lines,s)<0)
        return false;
        }
        catch(Exception e)
        {
        }*/ 
       
        return words.get(s) != null;
        
    }
    
    long findMatchedWords(String s,HashMap words,HashMap matchedWords,JSONArray matchedArrayJSON,int count)
    {
         String s1;
         int i=0;
         long totalFind=0;
        for (Iterator it = words.keySet().iterator();it.hasNext();) 
        {
            
            Object key = it.next();
            s1=key.toString();
            if(s1.contains(s))
            {
                totalFind++;
                i++;
                if(i>=count-10 && i<count ){
                    JSONObject matchedWordJSON=new JSONObject();
                    matchedWordJSON.put("id",s1);
                    matchedWordJSON.put("text",s1);
                    matchedArrayJSON.add(matchedWordJSON);
                    //
                    //matchedWords.put(s1,s1);
                }
            }
        }
        return totalFind;
    }
    boolean validateWord(String s)
    {
        String regex="[^a-z^A-Z]+";
        Pattern p1=Pattern.compile(regex);
        Matcher m1=p1.matcher(s);
        
        return m1.find();
    }
    boolean addWordInDB(String s)           
    {   
        boolean flag=false;
        try {
            String query2="insert into wordstable values (?);";

            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost/DB","root","");
            Statement st=c.createStatement();
            
            PreparedStatement pq2 = c.prepareStatement(query2);
            pq2.setString(1,s);
           
            if(pq2.executeUpdate()==1)
            {
                flag=true;
            }
            
            st.close();
            c.close();
           
        }catch (Exception ex) {
            
            
        }
     return flag;
    }
    
    void swap(char []arr,int i,int ind)
    {
        char temp=arr[i];
        arr[i]=arr[ind];
        arr[ind]=temp;
    }
    
    void next_perm(char [] arr,int index,HashMap words,JSONArray jArray)
   {
        int i=0;

        if(index==arr.length)
        {
            
            if(findWord(String.valueOf(arr),words))
            {    
                if(!Arrays.toString(arr).contains("'"))
                {
                    //sug1.append(String.valueOf(arr)).append(" ");
                    jArray.add(String.valueOf(arr));
                }
                    
            }
            return ;
        }
        for(i=index;i<arr.length;i++)
        {
            swap(arr,i,index);
            next_perm(arr,index+1,words,jArray);
            swap(arr,i,index);
        }
   }	

    void printSuggested(String s,HttpServletResponse res)
    {
        String fname;
        char st='a';
        String word;
        while(st<='z')
        {
            fname="E:/Sample Projects/ValidateWords/WordsList/"+st+" Words.txt";
            Path p1=Paths.get(fname);
            try
            {
                List<String> lines = Files.readAllLines(p1);

            }catch(Exception e){}
            
            st++;   
            try{
                
                
                List<String> lines = Files.readAllLines(p1);
                for (Iterator<String> it = lines.iterator(); it.hasNext();) {
                    word = it.next();
                    
                    if(word.contains(s))
                    {
                        out.print(word);
                        out.print(", ");
                    }
                }
                }catch(Exception e)
                {
                }
        }
    }
    
    void printSuggested2(String s,HashMap words,JSONArray similarWordArray)
    {
        String s1;
        int i,j,lpos=0;
        int mc=0;
        
        for (Iterator it = words.keySet().iterator(); it.hasNext();) {
            Object key = it.next();
            s1=key.toString();
            i=0;
            j=0;
            lpos=0;
            mc=0;
            if(s1.length()<=s.length()+2 && s1.length()>=s.length()-2)
            {
                while(i<s1.length() && j<s.length() )
                {
                    if(s.charAt(j)==s1.charAt(i))
                    {
                        lpos=j;
                        i++;
                        j++;
                        mc++;
                    }
                    else
                    {
                        if(j==s.length()-1)
                        {
                            i++;
                            j=lpos;
                        }
                        else
                            j++;

                    }
                }

                if(mc*100/s1.length() >=75)
                {
                    if(s1.indexOf("'")<0)
                    {
                        //sug2.append(s1).append(" ");
                        similarWordArray.add(s1);
                    }
                        
                }

            }
        }
    }
}
