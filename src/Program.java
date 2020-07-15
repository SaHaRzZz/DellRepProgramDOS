import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Program {
	
	public final static String newLine = System.lineSeparator();
	public static Scanner scan;
	public static String TF;
	public static boolean[] detailsArray; //0 = first name | 1 = last name | 2 = Phone | 3 = BackupPhone | 4 = Email
	public static String[] detailsArrayV;
	public static boolean[] techArray; //0 = Service Tag | 1 = Model | 2 = OS
	public static String[] techArrayV;
	public static boolean detailsOrTech; //false = details | true = tech
	public static boolean TDCrun;
	public static boolean programFinish;
	public static boolean techDone;
	public static boolean detailsDone;
	public static boolean finishINT;
	public static Runtime rt;
	public static boolean changeNothing;
	public static boolean TSfinish;
	public static String TS;
	public static boolean issue;
	public static boolean issueDate;
	public static String issueV;
	public static String issueDateV;
	public static boolean specialNameCall;
	
	//TODO add edit call check in TDC
	
	public static void main(String[]args) {
		System.out.println("@MADE BY SAHAR HAYUN@");
		System.out.println("Loading...");
		Setup();
		System.out.println("Loaded!");
		SS(100);
		System.out.println("Dell israel, this is SPECIFY_NAME speaking," + newLine + "who am I speaking with?"); //
		Details();
		while(!TSfinish)
			TS();
		AfterFinish();
	}
	
	public static void TDC() { //Tech/Details Call
		if(techDone && detailsDone)
			return;
		if(TF.equalsIgnoreCase("!tech") || TF.equalsIgnoreCase("!t")) {
			TDCrun = true;
			detailsOrTech = true;
			Tech();
		}else if(TF.equalsIgnoreCase("!details") || TF.equalsIgnoreCase("!detail") || TF.equalsIgnoreCase("!d")) {
			TDCrun = true;
			detailsOrTech = false;
			Details();
		}
		FC();
	}
	
	public static void FC() { //Finish Call
		
		if(techArray[0])
			System.out.println("ServiceTag: '" + techArrayV[0] + "'" + newLine);
		else
			System.out.println("NO SERVICE TAG" + newLine);
		
		if(TF.isEmpty()) {
			changeNothing = true;
			TDCrun = true;
		}else if(TF.equalsIgnoreCase("!FINISH")) {
			TDCrun = true;
			FINISH();
		}else if(TF.equalsIgnoreCase("!TT") || TF.equalsIgnoreCase("!TURBOTECH") || TF.equalsIgnoreCase("!TURBO") || TF.equalsIgnoreCase("!TECH")) {
			changeNothing = true;
			TDCrun = true;
			try {
				//rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\maxTT.bat");
				rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\TT.vbs");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(TF.equalsIgnoreCase("!OK") || TF.equalsIgnoreCase("!ORACLE") || TF.equalsIgnoreCase("!ORACLEKNOWLEDGE") || TF.equalsIgnoreCase("!KNOWLEDGE") || TF.equalsIgnoreCase("!ANSWER") || TF.equalsIgnoreCase("!ANSWERFLOW") || TF.equalsIgnoreCase("!AF")) {
			changeNothing = true;
			TDCrun = true;
			try {
				//rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\maxAnsweRable.bat");
				rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\AnsweRacle.vbs");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(TF.equalsIgnoreCase("!DE") || TF.equalsIgnoreCase("!DELTA")) {
			changeNothing = true;
			TDCrun = true;
			try {
				//rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\maxDelta.bat");
				rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\Delta.vbs");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(TF.equalsIgnoreCase("!STL") || TF.equalsIgnoreCase("!SERVICE TAG LOOKUP") || TF.equalsIgnoreCase("!TAG LOOKUP") || TF.equalsIgnoreCase("!TAG") || TF.equalsIgnoreCase("!LOOKUP") || TF.equalsIgnoreCase("!LOOKUP TAG")) {
			changeNothing = true;
			TDCrun = true;
			try {
				//rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\maxSTL.bat");
				rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\STL.vbs");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(TF.equalsIgnoreCase("!SPMD") || TF.equalsIgnoreCase("!PARTS") || TF.equalsIgnoreCase("!PART")) {
			changeNothing = true;
			TDCrun = true;
			try {
				//rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\maxSxxD.bat");
				rt.exec("wscript C:\\Users\\sahar.hayun\\Desktop\\JAVAFORFUN\\PROG\\SxxD.vbs");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(TF.equalsIgnoreCase("!P") || TF.equalsIgnoreCase("!PREVIEW") || TF.equalsIgnoreCase("!PRE")) {
			changeNothing = true;
			TDCrun = true;
			Preview();
		}else if(TF.equalsIgnoreCase("!C") || TF.equalsIgnoreCase("!CHECK")) {
			changeNothing = true;
			TDCrun = true;
			Check();
		}else if(TF.equalsIgnoreCase("!E") || TF.equalsIgnoreCase("!EDIT")) {
			changeNothing = true;
			TDCrun = true;
			Edit();
		}else if(TF.equalsIgnoreCase("!H") || TF.equalsIgnoreCase("!HELP")) {
			changeNothing = true;
			TDCrun = true;
			Help();
		}else if(TF.equalsIgnoreCase("!CLS")) {
			TDCrun = true;
			changeNothing = true;
			SS(80);
		}else if(TF.equalsIgnoreCase("!TEST") || TF.equalsIgnoreCase("!QA") || TF.equalsIgnoreCase("!INFO")) {
			if(detailsDone && techDone) {
				TDCrun = false;
				changeNothing = false;
				return;
			}else {
				changeNothing = true;
				TDCrun = true;
				System.out.println("NOT IN TS!");
			}
				
		}else if(TF.charAt(0) == '!') {
			changeNothing = true;
			TDCrun = true;
			System.out.println("INCORRECT COMMAND");
		}else if(TF.charAt(TF.length()-1) == '-'){
			changeNothing = true;
			TDCrun = true;
			System.out.println("CANCELED!");
		}
	}
	
	public static void FINISH() { 
		if(!finishINT) {
			if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")){
				return;
			}
			finishINT = true;
			TSfinish = true;
			programFinish = true;
			File file = new File("C:\\Users\\sahar.hayun\\Desktop\\SRs\\" + detailsArrayV[0] + " " + techArrayV[0] + ".txt");
			if(file.exists()) {
				System.out.println("A file named '" + detailsArrayV[0] + " " + techArrayV[0] + "' already exists!");
				System.out.println("Are you sure you want to overwrite it? Y/N");
				TF = scan.nextLine();
				TDC();
				if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
					TDCrun = false;
					return;
				}
				if(TF.equalsIgnoreCase("Y") || TF.equalsIgnoreCase("YES")){
					finishINT = true;
					TSfinish = true;
					programFinish = true;
					changeNothing = true;
					TDCrun = true;
					F_FINISH(file);
				}else {
					TDC();
					if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
						TDCrun = false;
						return;
					}
				}
			}else {
				changeNothing = true;
				TDCrun = true;
				F_FINISH(file);
			}
		}
	}
	
	public static void SS(int num) {
		for(int x = 0;x < num;x++)
			System.out.println();
	}
	
	public static void F_FINISH(File file){
		try {
			TSfinish = true;
			file.createNewFile();
			BufferedWriter write = new BufferedWriter(new FileWriter(file));
			
			if(detailsArrayV[2].charAt(0) == '0' && detailsArrayV[2].charAt(1) == '5') {
				detailsArrayV[2].replaceFirst("05", "+972");
			}
			
			if(techArray[0])
				write.write("ServiceTag: " + techArrayV[0] + newLine);
			else
				write.write("ServiceTag: N/A" + newLine);
			
			if(detailsArray[0])
				write.write("Name: " + detailsArrayV[0]);
			else
				write.write("Name: " + "N/A");
			
			if(detailsArray[1])
				write.write(" " + detailsArrayV[1] + newLine);
			else
				write.write(" " + "N/A" + newLine);
			
			if(detailsArray[2])
				if(detailsArrayV[2].charAt(0) == '0')
					write.write("Phone: " + detailsArrayV[2].replaceFirst("0", "+972") + newLine);
				else
					write.write("Phone: " + detailsArrayV[2] + newLine);
			else
				write.write("Phone: N/A" + newLine);
			
			if(detailsArray[3])
				if(detailsArrayV[3].charAt(0) == '0')
					write.write("BackupPhone: " + detailsArrayV[3].replaceFirst("0", "+972") + newLine);
				else
					write.write("BackupPhone: " + detailsArrayV[3] + newLine);
			else
				write.write("BackupPhone: N/A" + newLine);
			
			if(detailsArray[4])
				write.write("Email: " + detailsArrayV[4] + newLine);
			else
				write.write("Email: N/A" + newLine);
			
			if(techArray[1])
				write.write("Model: " + techArrayV[1] + newLine);
			else
				write.write("Model: N/A" + newLine);
			
			if(techArray[2])
				write.write("OS: " + techArrayV[2] + newLine);
			else
				write.write("OS: N/A" + newLine);
			
			if(issue)
				write.write(newLine + "Issue: " + issueV + newLine);
			else
				write.write(newLine + "Issue: N/A" + newLine);
			
			if(issueDate)
				write.write(newLine + "Issue Started: " + issueDateV + newLine);
			else
				write.write(newLine + "Issue Started: N/A" + newLine);
			
			write.write("TS" + newLine + TS);
			
			write.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Edit() {
		System.out.println("WARNING: YOU CAN'T USE COMMANDS WHEN EDITING!");
		System.out.println("!SERVICETAG/!NAME/!PHONE/!BACKUPPHONE/!EMAIL/!MODEL/!OS/!ISSUE/!ISSUESTARTED");
		boolean TFvalid = false;
		while(!TFvalid) {
			TFvalid = true;
			TF = scan.nextLine();
			if(TF.equalsIgnoreCase("!SERVICETAG")) {
				specialNameCall = true;
				runPro(100);
			}
			else if(TF.equalsIgnoreCase("!NAME")) {
				specialNameCall = true;
				runPro(0);
			}
			else if(TF.equalsIgnoreCase("!PHONE")) {
				specialNameCall = true;
				runPro(2);
			}
			else if(TF.equalsIgnoreCase("!BACKUPPHONE")) {
				specialNameCall = true;
				runPro(3);
			}
			else if(TF.equalsIgnoreCase("!EMAIL")) {
				specialNameCall = true;
				runPro(4);
			}
			else if(TF.equalsIgnoreCase("!MODEL")) {
				specialNameCall = true;
				runPro(101);
			}
			else if(TF.equalsIgnoreCase("!OS")) {
				specialNameCall = true;
				runPro(102);
			}
			else if(TF.equalsIgnoreCase("!ISSUE"))
				whatIsIssue();
			else if(TF.equalsIgnoreCase("!ISSUESTARTED"))
				whenIssueStart();
			else if(TF.charAt(0) == '!') {
				TFvalid = false;
				changeNothing = true;
				TDCrun = true;
				System.out.println("INCORRECT COMMAND");
			}else if(TF.charAt(TF.length()-1) == '-'){
				TFvalid = false;
				changeNothing = true;
				TDCrun = true;
				System.out.println("CANCELED!");
			}
		}
		TDCrun = false;
		changeNothing = false;
		TDCrun = true;
		changeNothing = true;
	}
	
	public static void Preview() {
		System.out.println("@@@@@@@@@@!PREVIEW!@@@@@@@@@@");
		if(techArray[0])
			System.out.print("ServiceTag: " + techArrayV[0] + newLine);
		else
			System.out.print("ServiceTag: N/A" + newLine);
		
		if(detailsArray[0])
			System.out.print("Name: " + detailsArrayV[0]);
		else
			System.out.print("Name: " + "N/A");
		
		if(detailsArray[1])
			System.out.print(" " + detailsArrayV[1] + newLine);
		else
			System.out.print(" " + "N/A" + newLine);
		
		if(detailsArray[2])
			if(detailsArrayV[2].charAt(0) == '0')
				System.out.print("Phone: " + detailsArrayV[2].replaceFirst("0", "+972") + newLine);
			else
				System.out.print("Phone: " + detailsArrayV[2] + newLine);
		else
			System.out.print("Phone: N/A" + newLine);
		
		if(detailsArray[3])
			if(detailsArrayV[3].charAt(0) == '0')
				System.out.print("BackupPhone: " + detailsArrayV[3].replaceFirst("0", "+972") + newLine);
			else
				System.out.print("BackupPhone: " + detailsArrayV[3] + newLine);
		else
			System.out.print("BackupPhone: N/A" + newLine);
		
		if(detailsArray[4])
			System.out.print("Email: " + detailsArrayV[4] + newLine);
		else
			System.out.print("Email: N/A" + newLine);
		
		if(techArray[1])
			System.out.print("Model: " + techArrayV[1] + newLine);
		else
			System.out.print("Model: N/A" + newLine);
		
		if(techArray[2])
			System.out.print("OS: " + techArrayV[2] + newLine);
		else
			System.out.print("OS: N/A" + newLine);
		
		if(issue)
			System.out.print(newLine + "Issue: " + issueV + newLine);
		else
			System.out.print(newLine + "Issue: N/A" + newLine);
		
		if(issueDate)
			System.out.print(newLine + "Issue Started: " + issueDateV + newLine);
		else
			System.out.print(newLine + "Issue Started: N/A" + newLine);
		
		System.out.print("TS" + newLine + TS);
		System.out.println("@@@@@@@@@@!PREVIEW!@@@@@@@@@@" + newLine);
		TDCrun = true;
		changeNothing = true;
	}
	
	public static void Check() {
		System.out.println("WARNING: YOU CAN'T USE COMMANDS WHEN CHECKING!");
		System.out.println("!SERVICETAG/!NAME/!PHONE/!BACKUPPHONE/!EMAIL/!MODEL/!OS/!ISSUE/!ISSUESTARTED");
		boolean TFvalid = false;
		while(!TFvalid) {
			TFvalid = true;
			TF = scan.nextLine();
			System.out.println();
			if(TF.equalsIgnoreCase("!SERVICETAG"))
				if(techArray[0])
					System.out.print("ServiceTag: " + techArrayV[0] + newLine);
				else
					System.out.print("ServiceTag: N/A" + newLine);
			else if(TF.equalsIgnoreCase("!NAME")) {
				if(detailsArray[0])
					System.out.print("Name: " + detailsArrayV[0]);
				else
					System.out.print("Name: " + "N/A");
				
				if(detailsArray[1])
					System.out.print(" " + detailsArrayV[1] + newLine);
				else
					System.out.print(" " + "N/A" + newLine);
			}else if(TF.equalsIgnoreCase("!PHONE"))
				if(detailsArray[2])
					if(detailsArrayV[2].charAt(0) == '0')
						System.out.print("Phone: " + detailsArrayV[2].replaceFirst("0", "+972") + newLine);
					else
						System.out.print("Phone: " + detailsArrayV[2] + newLine);
				else
					System.out.print("Phone: N/A" + newLine);
			else if(TF.equalsIgnoreCase("!BACKUPPHONE"))
				if(detailsArray[3])
					if(detailsArrayV[3].charAt(0) == '0')
						System.out.print("BackupPhone: " + detailsArrayV[3].replaceFirst("0", "+972") + newLine);
					else
						System.out.print("BackupPhone: " + detailsArrayV[3] + newLine);
				else
					System.out.print("BackupPhone: N/A" + newLine);
			else if(TF.equalsIgnoreCase("!EMAIL"))
				if(detailsArray[4])
					System.out.print("Email: " + detailsArrayV[4] + newLine);
				else
					System.out.print("Email: N/A" + newLine);
			else if(TF.equalsIgnoreCase("!MODEL"))
				if(techArray[1])
					System.out.print("Model: " + techArrayV[1] + newLine);
				else
					System.out.print("Model: N/A" + newLine);
			else if(TF.equalsIgnoreCase("!OS"))
				if(techArray[2])
					System.out.print("OS: " + techArrayV[2] + newLine);
				else
					System.out.print("OS: N/A" + newLine);
			else if(TF.equalsIgnoreCase("!ISSUE"))
				if(issue)
					System.out.print(newLine + "Issue: " + issueV + newLine);
				else
					System.out.print(newLine + "Issue: N/A" + newLine);
			else if(TF.equalsIgnoreCase("!ISSUESTARTED"))
				if(issueDate)
					System.out.print(newLine + "Issue Started: " + issueDateV + newLine);
				else
					System.out.print(newLine + "Issue Started: N/A" + newLine);
			else if(TF.charAt(0) == '!') {
				TFvalid = false;
				changeNothing = true;
				TDCrun = true;
				System.out.println("INCORRECT COMMAND");
			}else if(TF.charAt(TF.length()-1) == '-'){
				TFvalid = false;
				changeNothing = true;
				TDCrun = true;
				System.out.println("CANCELED!");
			}
		}
		System.out.println();
		TDCrun = true;
		changeNothing = true;
	}
	
	public static void Help() {
		System.out.println("!Tech");
		System.out.println("!Details");
		System.out.println();
		System.out.println("!Edit");
		System.out.println("!Check");
		System.out.println("!Preview");
		System.out.println("!Finish");
		System.out.println();
		System.out.println("!TURBOTECH");
		System.out.println("!DELTA");
		System.out.println("!SPMD");
		System.out.println("!STL");
		System.out.println("!ORACLE");
		System.out.println();
		System.out.println("!CLS");
		System.out.println();
		TDCrun = true;
		changeNothing = true;
	}
	
	public static void Tech() {
		boolean allDone = true;
		for(int x = 0;x < techArray.length;x++)
			if(!techArray[x]) {
				if(programFinish || finishINT)
					break;
				runPro(100+x);
				allDone = false;
			}
		if(allDone)
			if(detailsDone)
				techDone = true;
			else {
				techDone = true;
				detailsOrTech = false;
				Details();
			}
	}
	
	public static void Details() {
		boolean allDone = true;
		for(int x = 0;x < detailsArray.length;x++)
			if(!detailsArray[x]) {
				if(programFinish || finishINT)
					break;
				runPro(x);
				allDone = false;
			}
		if(allDone)
			if(techDone)
				detailsDone = true;
			else {
				detailsDone = true;
				detailsOrTech = true;
				Tech();
			}
	}
	
	public static void runPro(int ProNum){
		switch(ProNum) {
		case 0: //d - first name
			System.out.println("Customer First Name: name/N");
			TF = scan.nextLine();
			if(specialNameCall) {
				if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
					detailsArrayV[0] = "Customer";
					detailsArray[0] = true;
				}else{
					detailsArrayV[0] = TF;
					detailsArray[0] = true;
				}
				runPro(1);
				break;
			}
			TDC();
			if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
				TDCrun = false;
				changeNothing = false;
				break;
			}
			if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
				detailsArrayV[0] = "Customer";
				detailsArray[0] = true;
			}else{
				detailsArrayV[0] = TF;
				detailsArray[0] = true;
			}
			break;
		case 1: //d - last name
			System.out.println("Customer Last Name: name/N");
			TF = scan.nextLine();
			if(specialNameCall) {
				if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
					detailsArrayV[1] = "Customer";
					detailsArray[1] = true;
				}else{
					detailsArrayV[1] = TF;
					detailsArray[1] = true;
				}
				break;
			}
			TDC();
			if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
				TDCrun = false;
				changeNothing = false;
				break;
			}
			if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
				detailsArrayV[1] = "Customer";
				detailsArray[1] = true;
			}else{
				detailsArrayV[1] = TF;
				detailsArray[1] = true;
			}
			break;
		case 100: //t - service tag
			boolean confirm = false;
			if(specialNameCall) {
				while(!confirm) {
					System.out.println("WARNING: after entering ST you cannot switch to details before confirming ST!");
					System.out.println("Service Tag:");
					TF = scan.nextLine();
					techArrayV[0] = TF;
					System.out.println("Is the ST: (" + TF + ") ? Y/N");
					TF = scan.nextLine();
					if(TF.equalsIgnoreCase("Y") || TF.equalsIgnoreCase("YES")){
						confirm = true;
						techArray[0] = true;
						openSupport();
					}
				}
				break;
			}
			while(!confirm) {
				System.out.println("WARNING: after entering ST you cannot switch to details before confirming ST!");
				System.out.println("Service Tag:");
				TF = scan.nextLine();
				TDC();
				if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
					TDCrun = false;
					changeNothing = false;
					break;
				}
				techArrayV[0] = TF;
				System.out.println("Is the ST: (" + TF + ") ? Y/N");
				TF = scan.nextLine();
				FC();
				if(TF.equalsIgnoreCase("Y") || TF.equalsIgnoreCase("YES")){
					confirm = true;
					techArray[0] = true;
					openSupport();
				}
			}
			break;
		case 2: //d - phone
			System.out.println("Customer Phone: number/N");
			TF = scan.nextLine();
			if(specialNameCall) {
				if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
					detailsArrayV[2] = "N/A";
					detailsArray[2] = true;
				}else{
					detailsArrayV[2] = TF;
					detailsArray[2] = true;
				}
				break;
			}
			TDC();
			if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
				TDCrun = false;
				changeNothing = false;
				break;
			}
			if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
				detailsArrayV[2] = "N/A";
				detailsArray[2] = true;
			}else{
				detailsArrayV[2] = TF;
				detailsArray[2] = true;
			}
			break;
		case 3: //d - backupphone
			System.out.println("Customer BackupPhone: number/N");
			TF = scan.nextLine();
			if(specialNameCall) {
				if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
					detailsArrayV[3] = "N/A";
					detailsArray[3] = true;
				}else{
					detailsArrayV[3] = TF;
					detailsArray[3] = true;
				}
				break;
			}
			TDC();
			if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
				TDCrun = false;
				changeNothing = false;
				break;
			}
			if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
				detailsArrayV[3] = "N/A";
				detailsArray[3] = true;
			}else{
				detailsArrayV[3] = TF;
				detailsArray[3] = true;
			}
			break;
		case 4: // d - mail
			System.out.println("Customer Mail: mail/N");
			TF = scan.nextLine();
			if(specialNameCall) {
				if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
					detailsArrayV[4] = "no-email@dell.com";
					detailsArray[4] = true;
				}else{
					detailsArrayV[4] = TF;
					detailsArray[4] = true;
				}
				break;
			}
			TDC();
			if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
				TDCrun = false;
				changeNothing = false;
				break;
			}
			if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
				detailsArrayV[4] = "no-email@dell.com";
				detailsArray[4] = true;
			}else{
				detailsArrayV[4] = TF;
				detailsArray[4] = true;
			}
			break;
		case 101: //t - Model
			System.out.println("Customer Device Model: model/N");
			TF = scan.nextLine();
			if(specialNameCall) {
				if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
					techArrayV[1] = "N/A";
					techArray[1] = true;
				}else{
					techArrayV[1] = TF;
					techArray[1] = true;
				}
				break;
			}
			TDC();
			if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
				TDCrun = false;
				changeNothing = false;
				break;
			}
			if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
				techArrayV[1] = "N/A";
				techArray[1] = true;
			}else{
				techArrayV[1] = TF;
				techArray[1] = true;
			}
			break;
		case 102: //t - OS
			System.out.println("Customer OS: OS/N");
			TF = scan.nextLine();
			if(specialNameCall) {
				if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
					techArrayV[2] = "N/A";
					techArray[2] = true;
				}else{
					techArrayV[2] = TF;
					techArray[2] = true;
				}
				break;
			}
			TDC();
			if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true) ||(finishINT)) {
				TDCrun = false;
				changeNothing = false;
				break;
			}
			if(TF.equalsIgnoreCase("N") || TF.equalsIgnoreCase("NO")) {
				techArrayV[2] = "N/A";
				techArray[2] = true;
			}else{
				techArrayV[2] = TF;
				techArray[2] = true;
			}
			break;
		}
		
		specialNameCall = false;
		
		if(finishINT) {
			System.out.println("finishINT");
			return;
		}if(programFinish){
			System.out.println("programFinish");
			return;
		}
		else if(detailsOrTech)
			Tech();
		else
			Details();
	}
	
	public static void Setup() {
		
		scan = new Scanner(System.in);
		detailsArray = new boolean[5];
		detailsArrayV = new String[5];
		techArray = new boolean[3];
		techArrayV = new String[3];
		
		for(int x = 0;x < detailsArray.length;x++)
			detailsArray[x] = false;
		
		for(int x = 0;x < detailsArrayV.length;x++)
			detailsArrayV[x] = "N/A";
		
		for(int x = 0;x < techArray.length;x++)
			techArray[x] = false;
		
		for(int x = 0;x < techArrayV.length;x++)
			techArrayV[x] = "N/A";
		
		detailsArrayV[0] = "Customer";
		techArrayV[0] = "NoServiceTag";
		
		detailsOrTech = false;
		programFinish = false;
		techDone = false;
		detailsDone = false;
		finishINT = false;
		rt = Runtime.getRuntime();
		changeNothing = false;
		TSfinish = false;
		TS = "";
		issue = false;
		issueDate = false;
		issueV = "";
		issueDateV = "";
		specialNameCall = false;
		
		
	}
	
	public static void Pause() {
		System.out.println("PRESS ENTER TO CONTINUE...");
		scan.reset();
		scan.nextLine();
	}
	
	public static void openSupport(){
		String url = "http://www.dell.com/support/home/us/en/04/product-support/servicetag/" + techArrayV[0] + "/diagnose";
		try {
		rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TS() {
		detailsOrTech = false;
		while(!issue)
			whatIsIssue();
		while(!issueDate)
			whenIssueStart();
		System.out.println("Reminder: Ask Further Issues");
		System.out.println("Type TS method:");
		System.out.println("!TEST (Test, Result)");
		System.out.println("!QA (Question, Answer)");
		System.out.println("!INFO (Info)");
		System.out.println("!FINISH (Finish)");
		TF = scan.nextLine();
		FC();
		if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true)) {
			TDCrun = false;
			changeNothing = false;
			return;
		}
		if(TF.equalsIgnoreCase("!TEST")) {
			TStest();
		}else if(TF.equalsIgnoreCase("!QA")) {
			TSqa();
		}else if(TF.equalsIgnoreCase("!INFO")) {
			TSinfo();
		}
	}
	
	public static void whatIsIssue() {
		System.out.println("WARNING: can't edit Issue! (BUG)");
		System.out.print("What is the issue?: ");
		TF = scan.nextLine();
		FC();
		if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing)) {
			TDCrun = false;
			changeNothing = false;
			return;
		}
		issue = true;
		issueV = TF;
	}
	
	public static void whenIssueStart() {
		System.out.println("WARNING: can't edit Issue Date! (BUG)");
		System.out.print("When did the issue start?: ");
		TF = scan.nextLine();
		FC();
		if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true)) {
			TDCrun = false;
			changeNothing = false;
			return;
		}
		issueDate = true;
		issueDateV = TF;
	}
	
	public static void TStest() {
		String testHold = "";
		System.out.print("Test: ");
		TF = scan.nextLine();
		FC();
		if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true)) {
			TDCrun = false;
			changeNothing = false;
			return;
		}
		testHold = TF;
		System.out.print("Result: ");
		TF = scan.nextLine();
		FC();
		if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true)) {
			TDCrun = false;
			changeNothing = false;
			return;
		}
		TS += "Test: " + testHold + newLine + "Result: " + TF + newLine;
	}
	
	public static void TSinfo() {
		System.out.print("Info: ");
		TF = scan.nextLine();
		FC();
		if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true)) {
			TDCrun = false;
			changeNothing = false;
			return;
		}
		TS += "Info: " + TF + newLine;
	}
	
	public static void TSqa() {
		String questionHold = "";
		System.out.print("Question: ");
		TF = scan.nextLine();
		FC();
		if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true)) {
			TDCrun = false;
			changeNothing = false;
			return;
		}
		questionHold = TF;
		System.out.print("Answer: ");
		TF = scan.nextLine();
		FC();
		if((TDCrun && detailsOrTech == false) || (TDCrun && changeNothing == true)) {
			TDCrun = false;
			changeNothing = false;
			return;
		}
		TS += "Question: " + questionHold + newLine + "Answer: " + TF + newLine;
	}
	
	public static void AfterFinish() {
		System.out.println(newLine + "Reminder: Quiz");
	}
	
}