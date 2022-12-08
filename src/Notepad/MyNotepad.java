package Notepad;

import java.awt.Button;
import java.awt.CheckboxMenuItem;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyNotepad extends WindowAdapter implements ActionListener {
	Frame f;
	Dialog info;

	MyNotepad() {
		f = new Frame("메모장");
		f.addWindowListener(this);

		MenuBar mb = new MenuBar();
		Menu mFile = new Menu("파일(F)");
		Menu mEdit = new Menu("편집(E)");
		Menu mForm = new Menu("서식(O)");
		Menu mView = new Menu("보기(V)");
		Menu mHelp = new Menu("도움말(H)");
		Menu mZoom = new Menu("확대하기/축소하기  ");

		MenuItem miNew = new MenuItem("새로 만들기(N)");
		MenuItem miNewWin = new MenuItem("새창(W)");
		MenuItem miOpen = new MenuItem("열기(O)...");
		MenuItem miSave = new MenuItem("저장(S)");
		MenuItem miSaveAs = new MenuItem("다른 이름으로 저장(A)...");
		MenuItem miPage = new MenuItem("페이지 설정(U)...");
		MenuItem miPrt = new MenuItem("인쇄(P)...");
		MenuItem miExit = new MenuItem("끝내기(X)");

		CheckboxMenuItem miAutoNext = new CheckboxMenuItem("자동 줄 바꿈(W)");
		CheckboxMenuItem miStatusbar = new CheckboxMenuItem("상태 표시줄(S)");
		MenuItem miFont = new MenuItem("글꼴(F)...");

		MenuItem miIn = new MenuItem("확대(I)");
		MenuItem miOut = new MenuItem("축소(O)");
		MenuItem miDefault = new MenuItem("확대하기/축소하기 기본값 복원  ");

		MenuItem miViewHelp = new MenuItem("도움말 보기(H)  ");
		MenuItem miFeed = new MenuItem("피드백 보내기(F)  ");
		MenuItem miInfo = new MenuItem("메모장 정보(A)  ");

		PopupMenu pMenu = new PopupMenu("Popup");
		MenuItem miCancel = new MenuItem("실행 취소(U)  ");
		MenuItem miCancele = new MenuItem("실행 취소(U)  ");
		MenuItem miCut = new MenuItem("잘라내기(T)  ");
		MenuItem miCopy = new MenuItem("복사(C)  ");
		MenuItem miPaste = new MenuItem("붙여넣기(P)  ");
		MenuItem miDelete = new MenuItem("삭제(D)  ");
		MenuItem miAll = new MenuItem("모두 선택(A)  ");
		CheckboxMenuItem mitoLeft = new CheckboxMenuItem("오른쪽에서 왼쪽으로 읽기(R)");
		CheckboxMenuItem miUnicode = new CheckboxMenuItem("유니코드 제어 문자 표시(S)");
		Menu mInsert = new Menu("유니코드 제어 문자 삽입(I)");

		f.setMenuBar(mb);
		mb.add(mFile);
		mFile.add(miNew);
		mFile.add(miNewWin);
		mFile.add(miOpen);
		miOpen.addActionListener(this);
		mFile.add(miSave);
		mFile.add(miSaveAs);
		mFile.addSeparator();
		mFile.add(miPage);
		mFile.add(miPrt);
		mFile.addSeparator();
		mFile.add(miExit);
		miExit.addActionListener(this);

		mb.add(mEdit);
		mEdit.add(miCancele);
		mEdit.addSeparator();

		mb.add(mForm);
		mForm.add(miAutoNext);
		mForm.add(miFont);

		mb.add(mView);
		mView.add(mZoom);
		mZoom.add(miIn);
		mZoom.add(miOut);
		mZoom.add(miDefault);
		mView.add(miStatusbar);

		mb.add(mHelp);
		mHelp.add(miViewHelp);
		mHelp.add(miFeed);
		mHelp.addSeparator();
		mHelp.add(miInfo);
		miInfo.addActionListener(this);

		info = new Dialog(f, "메모장 정보", true);
		info.setSize(200, 100);
		info.setLocation(900, 500);
		info.setLayout(new FlowLayout());
		Label msg = new Label("Windows10", Label.CENTER);
		Button ok = new Button("확인");
		info.add(msg);
		info.add(ok);
		ok.addActionListener(this);

		f.add(pMenu);
		f.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {
					pMenu.show(f, me.getX(), me.getY());
				}
			}
		});

		pMenu.add(miCancel);
		pMenu.addSeparator();
		pMenu.add(miCut);
		pMenu.add(miCopy);
		pMenu.add(miPaste);
		pMenu.add(miDelete);
		pMenu.addSeparator();
		pMenu.add(miAll);
		pMenu.addSeparator();
		pMenu.add(mitoLeft);
		pMenu.add(miUnicode);
		pMenu.add(mInsert);

		TextArea comments = new TextArea();
		f.add(comments);

		f.setSize(700, 500);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		Dimension d = f.getSize();
		f.setLocation(screenSize.width / 2 - (int) (d.getWidth() / 2),
				screenSize.height / 2 - (int) (d.getHeight() / 2));
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0); // 프로그램 전체종료
	}

	public static void main(String[] args) {
		new MyNotepad();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fileOpen = new FileDialog(f, "File Open", FileDialog.LOAD);
		if (e.getActionCommand().equals("열기(O)...")) {
			f.setVisible(true);
			fileOpen.setDirectory("C:\\Windows");
			fileOpen.setVisible(true);
		}
		if (e.getActionCommand().equals("끝내기(X)")) {
			System.exit(0);
		}
		if (e.getActionCommand().equals("메모장 정보(A)  ")) {
			info.setVisible(true);
		}
		if (e.getActionCommand().equals("확인")) {
			info.dispose();
		}
	}
}
