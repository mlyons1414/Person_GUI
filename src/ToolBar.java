import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener {
	private JButton b1;
	private JButton b2;
	private StringListener textListener;
	
	public ToolBar() {
		b1 = new JButton("Hello");
		b2 = new JButton("Goodbye");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(b1);
		add(b2);
	}
	
	public void setStringListener(StringListener listener) {
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if (clicked == b1) {
			if(textListener != null) {
				textListener.textEmitted("Hello\n");
			}
		}
		else if (clicked == b2) {
			if(textListener != null) {
				textListener.textEmitted("Goodbye\n");
			}
		}
		
	}
}
