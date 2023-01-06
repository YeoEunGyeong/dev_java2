package dev_java2.basic1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatView extends JFrame implements ActionListener {
  // 선언
  String imgPath = "C:\\vscode_java_yeg\\dev_java_eg\\app\\src\\main\\java\\dev_java_eg\\images\\onion\\"; // 이미지 선언
  ImageIcon onionIcon = new ImageIcon(imgPath + "onion.png"); //
  JPanel centerPanel = new JPanel(); // 텍스트 메인 페널
  JPanel sendPanel = new JPanel(); // 텍스트 전송 페널
  JButton sendButton = new JButton("전송"); // 텍스트 전송 버튼
  JTextField chatTextField = new JTextField(24); // 텍스트 입력
  JTextArea chatDisplay = new JTextArea(15, 38); // 텍스트 전송 시 화면
  JScrollPane scrollPane = new JScrollPane(chatDisplay, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //

  // 생성
  public ChatView() {
    initDisplay();
  }

  // 화면
  public void initDisplay() {
    // 메인 페널
    centerPanel.setLayout(new BorderLayout());
    centerPanel.add("Center", scrollPane);
    centerPanel.add("South", sendPanel);
    // 전송 페널
    sendPanel.setLayout(new BorderLayout());
    sendPanel.add("Center", chatTextField);
    sendPanel.add("East", sendButton);
    // 전송 화면
    chatDisplay.setLineWrap(true); // 자동 줄바꿈
    chatDisplay.setEditable(false); // 텍스트 필드 입력 불가
    // 액션
    chatTextField.addActionListener(this);
    sendButton.addActionListener(this);

    this.setIconImage(onionIcon.getImage()); // 아이콘 선언
    this.setLayout(new GridLayout(1, 2));
    this.add(centerPanel);
    this.setTitle("양파쿵야TALK");
    this.setVisible(true);
    this.setSize(400, 600);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); // X 클릭 자동 종료
  }

  // 메인
  public static void main(String[] args) {
    new ChatView();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object object = e.getSource();

  }
}
// 강사님 채팅 이미지 삽입 구문 ? 어떻게 쓰는지
/*
 * final JTextPane textPane = new JTextPane();
 * textPane.setOpaque(false);
 * JViewport viewport = new JViewport() {
 * 
 * @Override
 * protected void paintComponent(Graphics g) {
 * Image img = iicon.getImage(); //
 * JTable jtb = new JTable(dtm);
 * setOpaque(false);
 * Graphics2D gd = (Graphics2D) g;
 * gd.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
 * g.drawImage(img, 0, 0, this);
 * super.paintComponent(g);
 * }
 * };
 */