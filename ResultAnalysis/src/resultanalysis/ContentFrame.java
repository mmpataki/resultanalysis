/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultanalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.io.*;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Madhusoodan Pataki
 */
@SuppressWarnings("InitializerMayBeStatic")
public class ContentFrame extends javax.swing.JFrame {

    /* used to switch the Go Button for importing the data */
    String selection = "";

    final String AdminData = "AdminData",
            RegularExamData = "RegularExamData",
            SupplExamData = "SupplExamData";

    /* Envoirnment varibales */
    String DBHost = "localhost",
            DBPort = "3306",
            RootDirectory = ".",
            DBUserName = "root",
            DBPassword = "sdmcet@2016",
            DBName = "exam_section",
            ConfigFile = "./configfile.txt";

    int dups = 0, foreignF = 0;

    public ContentFrame() {

        String branches[] = {"All Branches", "Chemical Engg.", "Computer Science Engg.", "Civil Engg.",
            "E & C Engg.", "E & E Engg.", "Information Science", "Mechanical Engg."};
        String quotas[] = {"CET", "COMEDK", "MGMT", "ALL"};

        try {
            readConfig();
            initComponents();
            selfTest();
            cleanDirectory();
            addYearRanges();
        } catch (Exception e) {
        }

        for (String arr1 : branches) {
            choice1.add(arr1);
        }
        for (String quota : quotas) {
            choice3.add(quota);
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {"GM", null, null, null},
                    {"SC", null, null, null},
                    {"ST", null, null, null},
                    {"OBC", null, null, null},
                    {"Total", null, null, null},},
                new String[]{
                    "Cateogory", "Registered", "Pass", "Fail"
                }
        ));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String datetoken[] = dateFormat.format(new Date()).split("/");
        int currentYear = Integer.parseInt(datetoken[datetoken.length - 1]);
        for (int i = 2000; i <= currentYear; i++) {
            yearSelector.add(new String(i + "-" + ("" + (i + 1)).substring(2)));
        }

        yearSelectorpane.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        choice3 = new java.awt.Choice();
        choice2 = new java.awt.Choice();
        choice1 = new java.awt.Choice();
        msgBox = new java.awt.Label();
        GetResultAnalysis = new javax.swing.JButton();
        EligibilityListgenerator = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        AdminDataImportbutton = new javax.swing.JButton();
        ImportExamdata = new javax.swing.JButton();
        ImportSupplimentryExamResult = new javax.swing.JButton();
        CreateConfig = new javax.swing.JButton();
        yearSelectorpane = new javax.swing.JPanel();
        yearSelector = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        GoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Result Analysis");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(29, 29, 29));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(200, 200, 200));
        jPanel2.setPreferredSize(new java.awt.Dimension(1500, 325));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Result Analysis");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setFocusable(false);
        jTable2.setRowHeight(30);
        jTable2.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        choice3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        choice2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        choice1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        choice1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        choice1.setName("SelectBranch"); // NOI18N

        msgBox.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        msgBox.setForeground(new java.awt.Color(255, 0, 0));

        GetResultAnalysis.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        GetResultAnalysis.setText("Get Result Analysis");
        GetResultAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetResultAnalysisActionPerformed(evt);
            }
        });

        EligibilityListgenerator.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        EligibilityListgenerator.setText("Generate Eligibilty List");
        EligibilityListgenerator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EligibilityListgeneratorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(GetResultAnalysis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EligibilityListgenerator)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choice2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(333, 333, 333)
                        .addComponent(msgBox, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GetResultAnalysis)
                    .addComponent(EligibilityListgenerator))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(msgBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))))
        );

        choice1.getAccessibleContext().setAccessibleName("SelectBranch");
        choice1.getAccessibleContext().setAccessibleDescription("");

        jPanel6.setBackground(new java.awt.Color(29, 29, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Categorywise Result Analysis");

        jPanel3.setBackground(new java.awt.Color(29, 29, 29));

        AdminDataImportbutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AdminDataImportbutton.setText("Import Admin Data");
        AdminDataImportbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminDataImportbuttonActionPerformed(evt);
            }
        });

        ImportExamdata.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ImportExamdata.setText("Import Exam data");
        ImportExamdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportExamdataActionPerformed(evt);
            }
        });

        ImportSupplimentryExamResult.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ImportSupplimentryExamResult.setText("Import Supplimentry Exam Data");
        ImportSupplimentryExamResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportSupplimentryExamResultActionPerformed(evt);
            }
        });

        CreateConfig.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CreateConfig.setText("CreateConfiguration");
        CreateConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AdminDataImportbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImportExamdata)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImportSupplimentryExamResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreateConfig)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminDataImportbutton)
                    .addComponent(ImportExamdata)
                    .addComponent(ImportSupplimentryExamResult)
                    .addComponent(CreateConfig)))
        );

        yearSelectorpane.setBackground(new java.awt.Color(29, 29, 29));
        yearSelectorpane.setEnabled(false);

        yearSelector.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Year of Import");

        GoButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        GoButton.setText("Go");
        GoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yearSelectorpaneLayout = new javax.swing.GroupLayout(yearSelectorpane);
        yearSelectorpane.setLayout(yearSelectorpaneLayout);
        yearSelectorpaneLayout.setHorizontalGroup(
            yearSelectorpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yearSelectorpaneLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GoButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        yearSelectorpaneLayout.setVerticalGroup(
            yearSelectorpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yearSelectorpaneLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(yearSelectorpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yearSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(yearSelectorpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yearSelectorpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void selfTest() {

        try {

            Connection myconn = DriverManager.getConnection("jdbc:mysql://" + DBHost + ":" + DBPort + "?autoReconnect=TRUE&useSSL=false", DBUserName, DBPassword);
            Statement stmt = myconn.createStatement();

            stmt.executeUpdate("create database " + DBName + ";");

            stmt = get_DB_Connection();
            stmt.executeUpdate(
                    "create table student (usn varchar(10) primary key, name varchar(100) not null,"
                    + "category varchar(10) not null,department varchar(10) not null,yearOj  int not null);"
            );

            stmt.executeUpdate(
                    "create table exam (usn varchar(10), courseid varchar(10), year int,\n"
                    + "sem int, grade varchar(3), credits int, gpoint float, primary key(usn, courseid, year),"
                    + "foreign key (usn) references student (usn) );"
            );
        } catch (Exception ex) {

        }

        try {
            File file = new File("./test.vbs");
            if (file.exists()) {
                return;
            }

            PrintWriter pw = new PrintWriter("./test.vbs");
            pw.print("Dim strFilename  \n"
                    + "Dim objFSO\n"
                    + "Set objFSO = CreateObject(\"scripting.filesystemobject\")  \n"
                    + "strFilename = WScript.Arguments.Item(0)\n"
                    + "If objFSO.fileexists(strFilename) Then  \n"
                    + "  Call Writefile(strFilename)  \n"
                    + "Else  \n"
                    + "  wscript.echo \"no such file!\"  \n"
                    + "End If  \n"
                    + "Set objFSO = Nothing  \n"
                    + "\n"
                    + "Sub Writefile(ByVal strFilename)  \n"
                    + "Dim objExcel  \n"
                    + "Dim objWB  \n"
                    + "Dim objws  \n"
                    + "\n"
                    + "Set objExcel = CreateObject(\"Excel.Application\")  \n"
                    + "Set objWB = objExcel.Workbooks.Open(strFilename)  \n"
                    + "\n"
                    + "For Each objws In objWB.Sheets  \n"
                    + "  objws.Copy  \n"
                    + "  objExcel.ActiveWorkbook.SaveAs objWB.Path & \"\\\" & objws.Name & \".csv\", 6  \n"
                    + "  objExcel.ActiveWorkbook.Close False  \n"
                    + "Next \n"
                    + "\n"
                    + "objWB.Close False  \n"
                    + "objExcel.Quit  \n"
                    + "Set objExcel = Nothing  \n"
                    + "End Sub  ");
            pw.close();
        } catch (Exception e) {
        }
    }

    void toggleEnability(boolean b) {
        yearSelectorpane.setSize(yearSelectorpane.getWidth(), (b ? 400 : 0));
        yearSelectorpane.setVisible(b);
    }

    private void cleanDirectory() {
        final File folder = new File(RootDirectory);

        for (final File fe : folder.listFiles()) {
            if (fe.getName().contains(".csv")
                    || fe.getName().contains(".xls")
                    || fe.getName().contains(".xlsx")) {
                fe.delete();
            }
        }
    }

    void setMessage(String msg) {
        msgBox.setText(msg);
    }

    private void deleteFile(String fname) {
        File f = new File(fname);
        if (f != null) {
            f.delete();
        }
    }

    File get_Selected_File_Copied() {

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS/XLSX FILES", "xls", "xlsx");
        fileChooser.setFileFilter(filter);

        String filepath, destpath;
        File dest = null, source = null;

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            filepath = fileChooser.getSelectedFile().getAbsolutePath();
            destpath = RootDirectory + "/" + fileChooser.getSelectedFile().getName();
            dest = new File(destpath);
            source = new File(filepath);

            try {
                Files.copy(source.toPath(), dest.toPath(), REPLACE_EXISTING);
            } catch (Exception e) {
            }
        }
        return dest;
    }

    Statement get_DB_Connection() {
        Connection myconn = null;
        Statement stmt = null;

        try {
            myconn = DriverManager.getConnection("jdbc:mysql://" + DBHost + ":" + DBPort + "/" + DBName + "?autoReconnect=TRUE&useSSL=false", DBUserName, DBPassword);
            stmt = myconn.createStatement();
        } catch (Exception e) {
            setMessage("Connection to DB failed. Try checking configuration file");
        }
        return stmt;
    }

    void convert_to_CSV(File file) {
        try {
            Process p = Runtime.getRuntime().exec("wscript \"./test.vbs\" \"" + file.getAbsolutePath() + "\"");
            p.waitFor();
        } catch (Exception e) {
            setMessage("Convertion to CSV failed");
        }
    }

    private void addYearRanges() throws SQLException {

        Statement stmt = get_DB_Connection();
        String minquery, maxquery;
        ResultSet oset;

        minquery = "select year from Exam group by year order by year asc  limit 1;";
        maxquery = "select year from Exam group by year order by year desc limit 1;";

        int min = 2000, max = 100;

        oset = stmt.executeQuery(maxquery);
        while (oset.next()) {
            max = Integer.parseInt(oset.getString("year"));
        }

        oset = stmt.executeQuery(minquery);
        while (oset.next()) {
            min = Integer.parseInt(oset.getString("year"));
        }

        for (int i = min; i <= max; i++) {
            String last = ((i + 1) + "").substring(2);
            choice2.add(new String(i + "-" + last));
        }
    }

    private void readConfig() {
        File file = new File(ConfigFile);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String kvp[] = line.split(":");

                if (kvp.length < 2) {
                    continue;
                }

                kvp[0] = kvp[0].trim();

                if (kvp[0].charAt(0) == '#') {
                    //It'a comment continue for next line
                    continue;
                }

                for (int i = 2; i < kvp.length; i++) {
                    kvp[1] += ":" + kvp[i];
                }

                switch (kvp[0].toUpperCase()) {
                    case "DBUSERNAME":
                        DBUserName = new String(kvp[1].trim());
                        break;
                    case "DBPASSWORD":
                        DBPassword = new String(kvp[1].trim());
                        break;
                    case "TEMPDIR":
                        RootDirectory = new String(kvp[1].trim());
                        break;
                    case "DBNAME":
                        DBName = new String(kvp[1].trim());
                        break;
                    case "DBHOST":
                        DBHost = new String(kvp[1].trim());
                        break;
                    case "DBPORT":
                        DBPort = new String(kvp[1].trim());
                        break;
                    default:
                        setMessage("Corrupted configuration file");
                        break;
                }
            }
        } catch (Exception e) {
        }

        File f = new File(RootDirectory);
        if (!f.exists()) {
            (new File(RootDirectory)).mkdir();
        }
    }

    /* Import Regular Exam Data */
    //Execution
    public void addExamData(String filename) throws SQLException, FileNotFoundException, IOException {
        // TODO Auto-generated method stub

        String query = "", line = "";
        String[] courses = new String[100];
        int year = 0, sem = 0, num_of_courses = 0, flag = 0, endouterloop = 0;
        Statement stmt = get_DB_Connection();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        while (endouterloop == 0) {
            try {

                while ((line = br.readLine()) != null) {
                    // process the line.

                    String[] arr = line.split(",");

                    if (line.contains("FIRST")) {
                        sem = 1;
                    } else if (line.contains("SECOND")) {
                        sem = 2;
                    } else if (line.contains("THIRD")) {
                        sem = 3;
                    } else if (line.contains("FOURTH")) {
                        sem = 4;
                    } else if (line.contains("FIFTH")) {
                        sem = 5;
                    } else if (line.contains("SIXTH")) {
                        sem = 6;
                    } else if (line.contains("SEVENTH")) {
                        sem = 7;
                    } else if (line.contains("EIGHTH")) {
                        sem = 8;
                    }

                    int nulls = 0;
                    int i = 0;
                    for (i = 0; i < arr.length; i++) {
                        if (arr[i].equals(""))
		    			;

                    }

                    year = Integer.parseInt(yearSelector.getSelectedItem().split("-")[0]);

                    int j = 0;

                    if (line.contains("USN")) {
                        for (j = 0; j < arr.length; j++) {
                            if (arr[j].contains("USN")) {
                                flag = j;
                                break;

                            }
                        }
                        System.out.println("flag= " + flag);
                        j = 0;
                        for (int k = flag + 1; k < arr.length && !(arr[k].contains("TOTAL CREDITS")); k++) {

                            if (arr[k].equals("")) {
                                continue;
                            }
                            courses[j] = arr[k];

                            j++;
                            num_of_courses++;

                        }
                    } else if (line.contains("2SD")) {

                        int ch = 0;
                        i = 0;

                        for (j = 0; j < num_of_courses; j++) {

                            if (!courses[j].contains("HU") && arr[flag + j * 3 + 1].equals("")/*||(courses[j-1].contains("HU")&&arr[j*3-1].equals(""))*/) {
                                continue;
                            }
                            if ((courses[j].contains("HU"))) {
                                if (j != 0 && courses[j - 1].contains("HU") && arr[flag + j * 3 - 1].equals("")) {
                                    continue;
                                } else if (j != 0 && !courses[j - 1].contains("HU") && arr[flag + j * 3 + 1].equals("")) {
                                    continue;
                                }
                            }

                            // System.out.println("Hello");
                            //  System.out.println(courses[j]);
                            // System.out.println("Hello");
                            if (courses[j].contains("HU") && (sem == 1 || sem == 2)) {
                                if (!courses[j - 1].contains("HU")) {

                                    query = "insert into exam(usn,courseid,sem,year,grade,gpoint,credits) values(\"" + arr[flag] + "\", \"" + courses[j] + "\"," + sem + "," + year + ",\"" + arr[flag + j * 3 + 1] + "\"," + ch + "," + "0);";
                                    i = flag + j * 3 + 1;
                                } else {

                                    query = "insert into exam(usn,courseid,sem,year,grade,gpoint,credits) values(\"" + arr[flag] + "\", \"" + courses[j] + "\"," + sem + "," + year + ",\"" + arr[flag + j * 3 - 1] + "\"," + ch + "," + "0);";
                                    i = flag + j * 3 - 1;
                                }
                            } else if (!courses[j].contains("HU")) {

                                query = "insert into exam(usn,courseid,sem,year,grade,gpoint,credits) values(\"" + arr[flag] + "\", \"" + courses[j] + "\",\"" + sem + "\"," + year + ",\"" + arr[flag + j * 3 + 1] + "\" ," + arr[flag + j * 3 + 2] + ", " + arr[flag + j * 3 + 3] + ");";
                                i = flag + j * 3 + 3;
                            }
                            //System.out.println(query);
                            stmt.executeUpdate(query);
                        }

                    }
                }
                endouterloop = 1;
                break;
            } catch (Exception e) {
                if (e.getMessage().toString().contains("Duplicate")) {
                    dups++;
                } else if (e.getMessage().toString().contains("foreign")) {
                    foreignF++;
                }
            }
        }
    }

    //Preparation
    void importRegExamData() {
        try {

            convert_to_CSV(get_Selected_File_Copied());
            File folder = new File(RootDirectory);

            for (File fe : folder.listFiles()) {
                if (fe.getName().contains(".csv")) {
                    addExamData(fe.getAbsolutePath());
                    fe.delete();
                }
            }
        } catch (Exception ex) {
        }
    }

    /* import supplimentry exam data. */
    //Preparation
    void importSupplExamData() {

        try {

            convert_to_CSV(get_Selected_File_Copied());
            final File folder = new File(RootDirectory);

            for (final File fe : folder.listFiles()) {

                if (fe.getName().contains(".csv")) {
                    addSupplementary(fe.getAbsolutePath());
                }
            }
        } catch (Exception ex) {
        }
    }

    //Execution
    public void addSupplementary(String filename) throws SQLException, FileNotFoundException, IOException {

        String query = "", line = "";
        int year = 0, i = 0;
        Statement stmt;

        try {

            BufferedReader br = new BufferedReader(new FileReader(filename));
            stmt = get_DB_Connection();

            while ((line = br.readLine()) != null) {

                String[] arr = line.split(",");

                year = Integer.parseInt(yearSelector.getSelectedItem().split("-")[0]);

                int j = 0;
                int flag = 0;
                if (line.contains("USN")) {
                    for (j = 0; j < arr.length; j++) {
                        if (!arr[j].contains("USN")) {
                            continue;
                        } else {
                            flag = j;
                            break;
                        }
                    }
                    //System.out.println("flag= " + flag);
                    j = 0;

                } else if (line.contains("2SD")) {

                    i = 0;
                    year = 0;

                    if (arr[flag + 2].equals("")) {
                        arr[flag + 2] = "0";
                    }
                    query = "update exam set grade=\"*" + arr[flag + 4] + "\" where usn=\"" + arr[flag] + "\" and courseid=\"" + arr[flag + 3] + "\";";

                    //System.out.println(query);
                    stmt.executeUpdate(query);

                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }


    /* Admin Data Import Button */
    //Preparation
    void importAdminData() {
        try {

            convert_to_CSV(get_Selected_File_Copied());
            final File folder = new File(RootDirectory);

            for (final File fe : folder.listFiles()) {
                if (fe.getName().contains(".csv")) {
                    addStudentDetails(fe.getAbsolutePath());
                    fe.delete();
                }
            }
        } catch (Exception e) {
        }
    }

    //Execution
    public void addStudentDetails(String filename) throws SQLException, FileNotFoundException, IOException {

        // TODO Auto-generated method stub
        Statement stmt = get_DB_Connection();
        String query, quota = "", line = "";

        try {

            BufferedReader br = new BufferedReader(new FileReader(filename));
            int endwhile = 0;
            while (endwhile == 0) {

                while ((line = br.readLine()) != null) {
                    // process the line.

                    String[] arr = line.split(",");

                    if (arr.length < 7) {
                        continue;
                    }

                    int nulls = 0;
                    for (String arr1 : arr) {
                        if (arr1.equals("")) {
                            nulls++;
                        }
                    }

                    if (arr[1].contains("2SD")) {

                        int ch = 0;
                        final String[] cats = {"GM", "SC", "ST", "OBC"};

                        query = "insert into Student values(\"" + arr[1] + "\", \"" + arr[2] + "\", \"";

                        query += arr[7] + arr[3] + "\", \"" + arr[1].substring(5, 7) + "\", 20" + arr[1].substring(3, 5) + ");";

                        System.out.println(query);
                        stmt.executeUpdate(query);
                    }
                }
                endwhile = 1;

            }
        } catch (Exception e) {
            System.out.println(line);
            System.out.println(e.toString());
        }

    }

    /* To disable if not needed */
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        toggleEnability(false);
    }//GEN-LAST:event_jPanel1MousePressed

    private void AdminDataImportbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminDataImportbuttonActionPerformed
        setMessage("Please Wait....");
        importAdminData();
        setMessage("Done.");
    }//GEN-LAST:event_AdminDataImportbuttonActionPerformed

    private void ImportExamdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportExamdataActionPerformed
        try {
            selection = RegularExamData;
            toggleEnability(true);
            addYearRanges();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_ImportExamdataActionPerformed

    private void ImportSupplimentryExamResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportSupplimentryExamResultActionPerformed
        selection = SupplExamData;
        toggleEnability(true);
    }//GEN-LAST:event_ImportSupplimentryExamResultActionPerformed

    private void CreateConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateConfigActionPerformed
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(ConfigFile, "ASCII");
            writer.println("# This is a config file for Result Analysis");
            writer.println("#");
            writer.println("# The lines preceeding with # are comments which are ignored");
            writer.println("#");
            writer.println("# Specify options as OptionName : OptionValue");
            writer.println("# The OptionNames are case insensitive");
            writer.println("# ");
            writer.println("# Mandatory");
            writer.println("# 1. DBUserName    (Database username usually root)");
            writer.println("DBUserName : " + DBUserName);
            writer.println("");
            writer.println("# 2. DBPassword    (Password for the database user)");
            writer.println("DBPassword : " + DBPassword);
            writer.println("");
            writer.println("# 3. TempDirectory");
            writer.println("# (Directory where the temporary file can be found [Helps in Debugging])");
            writer.println("# You can use any type of path relative as \".\" or absolute as");
            writer.println("# \"C:\\Users\\A Mahesh Bhat\\Desktop\\Documents1\\ResultAnalysis\"");
            writer.println("TempDir : " + RootDirectory);
            writer.println("");
            writer.println("# Optional");
            writer.println("# Don't change until you really know what these are");
            writer.println("");
            writer.println("# 4. DBHost (Ip/Host name of the machine)");
            writer.println("# DBHost : " + DBHost);
            writer.println("");
            writer.println("# 5. DBPort (Port on which the mySQL is running)");
            writer.println("# DBPort : " + DBPort);
            writer.println("");
            writer.println("# 6. DBName        (Database name)");
            writer.println("# DBName : " + DBName);
            writer.println("#");
            writer.println("# To get the default values comment that line using '#'");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            setMessage("Couldn't create config file. Access denied.");
        } finally {
            try {
                writer.close();
                Process p = Runtime.getRuntime().exec("notepad.exe " + ConfigFile);
                p.waitFor();
            } catch (IOException | InterruptedException e) {
            }
            readConfig();
            setMessage("Configureation saved");
        }
    }//GEN-LAST:event_CreateConfigActionPerformed

    private void GoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoButtonActionPerformed
        setMessage("Please Wait...");
        dups = 0;
        foreignF = 0;

        switch (selection) {
            case AdminData:
                break;
            case RegularExamData:
                importRegExamData();
                break;
            case SupplExamData:
                importSupplExamData();
        }
        if (dups != 0) {
            JOptionPane.showMessageDialog(this, "Import Done. However there were " + dups + " duplicates.");
        }
        if (foreignF != 0) {
            JOptionPane.showMessageDialog(this, "Import Done. However " + foreignF + " student entries were not found in Admin data.");
        }
        setMessage("Done.");
        toggleEnability(false);
    }//GEN-LAST:event_GoButtonActionPerformed

    private void GetResultAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetResultAnalysisActionPerformed

        try {

            Statement stmt = get_DB_Connection();
            String category, department, batch, query, yoj;
            ResultSet s = null;
            Integer nullval = 0;
            final int GM_IND = 0, SC_IND = 1, ST_IND = 2, OBC_IND = 3, TOT_IND = 4;
            int total = 0, obcs = 0, scs = 0, sts = 0, gms = 0;

            Object dataSet[][] = {
                {"GM", nullval, nullval, nullval},
                {"SC", nullval, nullval, nullval},
                {"ST", nullval, nullval, nullval},
                {"OBC", nullval, nullval, nullval},
                {"Total", nullval, nullval, nullval}
            };

            category = choice3.getSelectedItem();
            department = choice1.getSelectedItem();
            batch = choice2.getSelectedItem();
            yoj = batch.split("-")[0];

            switch (department) {
                case "All Branches":
                    department = "%";
                    break;
                case "Chemical Engg.":
                    department = "CH";
                    break;
                case "Computer Science Engg.":
                    department = "CS";
                    break;
                case "Civil Engg.":
                    department = "CV";
                    break;
                case "E & C Engg.":
                    department = "EC";
                    break;
                case "E & E Engg.":
                    department = "EE";
                    break;
                case "Information Science":
                    department = "IS";
                    break;
                case "Mechanical Engg.":
                    department = "ME";
                    break;
            }

            if (category.contains("ALL")) {
                category = "%";
            }

            if (department.equalsIgnoreCase("All departments")) {
                department = "%";
            }

            if (category.contains("MG")) {
                category = "MGT";
            }

            String[] queries = {
                /* total query */
                "SELECT category, COUNT(*) FROM Student where department like \'" + department + "\' and yearOj=\'" + yoj + "\' group By category having category like \'" + category + "%\'",
                /* pass query */
                "SELECT category, COUNT(*) FROM STUDENT S WHERE\n S.yearoj=\'" + yoj + "\'AND S.DEPARTMENT LIKE \'" + department + "\' AND "
                + "USN NOT IN (SELECT USN FROM EXAM E WHERE S.USN=E.USN\n"
                + "GROUP BY USN,GRADE\n"
                + "HAVING GRADE='F' AND COUNT(*)>4)\n"
                + "GROUP BY CATEGORY  HAVING S.CATEGORY like '" + category + "%';",
                /* fail query */
                "SELECT category, COUNT(*) FROM STUDENT S WHERE\n S.yearOJ=\'" + yoj + "\'AND S.DEPARTMENT LIKE \'" + department + "\' AND "
                + "USN IN (SELECT USN FROM EXAM E WHERE S.USN=E.USN\n"
                + "GROUP BY USN,GRADE\n"
                + "HAVING GRADE='F' AND COUNT(*)>4)\n"
                + "GROUP BY CATEGORY HAVING S.CATEGORY like '" + category + "%';"
            };

            for (int i = 1; i < 4; i++) {

                scs = sts = gms = total = obcs = 0;

                s = stmt.executeQuery(queries[i - 1]);
                System.out.println(">>>> " + queries[i - 1] + "   <<<<\n\n\n");

                while (s.next()) {

                    String col = s.getString("category");

                    query = s.getString("COUNT(*)");

                    Integer nstr = new Integer(query);

                    if (col.contains("GM")) {
                        gms += nstr;
                    } else if (col.contains("SC")) {
                        scs += nstr;
                    } else if (col.contains("ST")) {
                        sts += nstr;
                    } else {
                        obcs += nstr;
                    }

                    total += Integer.parseInt(query);
                }

                dataSet[GM_IND][i] = new Integer(gms);
                dataSet[SC_IND][i] = new Integer(scs);
                dataSet[ST_IND][i] = new Integer(sts);
                dataSet[OBC_IND][i] = new Integer(obcs);
                dataSet[TOT_IND][i] = new Integer(total);
            }

            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                    dataSet,
                    new String[]{
                        "Cateogory", "Registered", "Pass", "Fail"
                    }
            ));
        } catch (SQLException ex) {
            setMessage("Couldn't analyse the data. May be there is no data");
        }
    }//GEN-LAST:event_GetResultAnalysisActionPerformed

    private void EligibilityListgeneratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EligibilityListgeneratorActionPerformed

        String category, department, batch;
        String query;
        category = choice3.getSelectedItem();
        department = choice1.getSelectedItem();
        batch = choice2.getSelectedItem();

        String yoj = batch.split("-")[0];

        switch (department) {
            case "All Branches":
                department = "%";
                break;
            case "Chemical Engg.":
                department = "CH";
                break;
            case "Computer Science Engg.":
                department = "CS";
                break;
            case "Civil Engg.":
                department = "CV";
                break;
            case "E & C Engg.":
                department = "EC";
                break;
            case "E & E Engg.":
                department = "EE";
                break;
            case "Information Science":
                department = "IS";
                break;
            case "Mechanical Engg.":
                department = "ME";
                break;
        }

        if (category.contains("ALL")) {
            category = "%";
        }

        try {

            Statement st = get_DB_Connection();

            //String quota1 ="All";
            query = "select usn,name from Student S where category like \'" + category + "%\' and department like \'" + department + "\' and yearoj=\'" + yoj + "\' and usn not in(SELECT USN FROM EXAM E WHERE S.USN=E.USN group by usn,grade HAVING GRADE='F' AND COUNT(*)>4);";
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);

            JFileChooser fileChooser = new JFileChooser();
            JTextField textField = new JTextField(30);

            PrintWriter csvWriter = null;
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                csvWriter = new PrintWriter(new File(fileChooser.getSelectedFile().getAbsolutePath() + ".csv"));
            }

            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            String dataHeaders = meta.getColumnName(1);
            for (int i = 2; i < numberOfColumns + 1; i++) {
                dataHeaders += "," + meta.getColumnName(i);
            }
            csvWriter.println(dataHeaders);
            while (rs.next()) {
                String row = "\"" + rs.getString(1) + "\"";
                for (int i = 2; i < numberOfColumns + 1; i++) {
                    row += ",\"" + rs.getString(i) + "\"";
                }

                System.out.println(row);
                csvWriter.println(row);
            }
            csvWriter.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_EligibilityListgeneratorActionPerformed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ContentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ContentFrame().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminDataImportbutton;
    private javax.swing.JButton CreateConfig;
    private javax.swing.JButton EligibilityListgenerator;
    private javax.swing.JButton GetResultAnalysis;
    private javax.swing.JButton GoButton;
    private javax.swing.JButton ImportExamdata;
    private javax.swing.JButton ImportSupplimentryExamResult;
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private java.awt.Choice choice3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private java.awt.Label msgBox;
    private java.awt.Choice yearSelector;
    private javax.swing.JPanel yearSelectorpane;
    // End of variables declaration//GEN-END:variables
}
