/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
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

            JSONObject wordObj=new JSONObject();
            JSONArray matchedArrayJSON=new JSONArray();
            String s=request.getParameter("inputStr");
            int page=Integer.parseInt(request.getParameter("page"));
            int count;
            count=page*10;
                
            totalFind=findMatchedWords(s,words,matchedWords,matchedArrayJSON,count);
            wordObj.put("matchedArrayJSON",matchedArrayJSON);
            wordObj.put("totalFind",totalFind);

            call_Webpage(request,response,wordObj);
        }finally {
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
    }
    
    
    void call_Webpage(HttpServletRequest request, HttpServletResponse response,JSONObject wordObj)
    {
        try{
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(String.valueOf(wordObj));
        }catch(Exception e)
        {
            
        }
    }
    
   
    boolean findWord(String s,HashMap words)
    {
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
                }
            }
        }
        return totalFind;
    }
}
