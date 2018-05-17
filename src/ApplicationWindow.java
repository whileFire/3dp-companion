import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ApplicationWindow extends JFrame {

	private JPanel contentPane;
	
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow frame = new ApplicationWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public ApplicationWindow() {
		
		//Test/On-Run
		
		
		
		//End Test/On-Run
		
		// =======
		
		//Projects Import
		Application a1 = new Application();
		a1.initializeFolderStructure();
		HashMap<Integer, Project> projects = a1.importProjects();
		
		
		//End Projects Import
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 384, 562);
		contentPane.add(tabbedPane);
		
		JPanel pnl_projectView = new JPanel();
		tabbedPane.addTab("View", null, pnl_projectView, null);
		pnl_projectView.setLayout(null);
		
		JPanel panel_projectList = new JPanel();
		panel_projectList.setBounds(10, 11, 120, 200);
		pnl_projectView.add(panel_projectList);
		panel_projectList.setLayout(null);
		
		/*
		 *	My listbox
		 */
		JList<String> list = new JList<String>();
		list.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return projects.size();
			}
			public String getElementAt(int index) {
				return projects.get(index + 1).getProjectName();
			}
		});		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(0, 0, 120, 200);
		panel_projectList.add(list);
		
		JPanel panel_details = new JPanel();
		panel_details.setBounds(10, 222, 359, 61);
		pnl_projectView.add(panel_details);
		panel_details.setLayout(null);
		
		JLabel lbl_projectName = new JLabel("Project Name:");
		lbl_projectName.setBounds(10, 11, 120, 14);
		panel_details.add(lbl_projectName);
		
		JLabel lbl_projectDimensions = new JLabel("Project Dimensions:");
		lbl_projectDimensions.setBounds(10, 36, 120, 14);
		panel_details.add(lbl_projectDimensions);
		
		JLabel lbl_name = new JLabel("");
		lbl_name.setBounds(140, 11, 209, 14);
		panel_details.add(lbl_name);
		
		JLabel lbl_projectWidth = new JLabel("W:");
		lbl_projectWidth.setBounds(140, 36, 16, 14);
		panel_details.add(lbl_projectWidth);
		
		JLabel lbl_width = new JLabel("");
		lbl_width.setBounds(158, 36, 36, 14);
		panel_details.add(lbl_width);
		
		JLabel lbl_projectLength = new JLabel("L:");
		lbl_projectLength.setBounds(196, 36, 14, 14);
		panel_details.add(lbl_projectLength);
		
		JLabel lbl_length = new JLabel("");
		lbl_length.setBounds(212, 36, 36, 14);
		panel_details.add(lbl_length);
		
		JLabel lbl_projectHeight = new JLabel("H:");
		lbl_projectHeight.setBounds(252, 36, 14, 14);
		panel_details.add(lbl_projectHeight);
		
		JLabel lbl_height = new JLabel("");
		lbl_height.setBounds(266, 36, 36, 14);
		panel_details.add(lbl_height);
		
		JPanel panel_functions = new JPanel();
		panel_functions.setBounds(10, 296, 359, 227);
		pnl_projectView.add(panel_functions);
		panel_functions.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 11, 89, 23);
		panel_functions.add(btnNewButton);
		
		JPanel panel_projects = new JPanel();
		panel_projects.setBounds(140, 11, 229, 200);
		pnl_projectView.add(panel_projects);
		panel_projects.setLayout(null);
		
		JLabel lbl_projectImage = new JLabel("");
		lbl_projectImage.setVerticalAlignment(SwingConstants.TOP);
		lbl_projectImage.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_projectImage.setIcon(new ImageIcon("C:\\Users\\Ashley\\Pictures\\Food\\tumblr_p4r91d7O0P1rvhh30o1_540.jpg"));
		lbl_projectImage.setBounds(0, 0, 229, 200);
		panel_projects.add(lbl_projectImage);
		
		JPanel pnl_projectMaker = new JPanel();
		tabbedPane.addTab("Project", null, pnl_projectMaker, null);
		

		
		/*
		 * 	My Listbox Listener
		 */
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(!arg0.getValueIsAdjusting()) {
					lbl_projectImage.setIcon(projects.get(list.getSelectedIndex() + 1).getProjectPicture());
					lbl_name.setText(projects.get(list.getSelectedIndex()+1).getProjectName());
					lbl_height.setText(String.valueOf(projects.get(list.getSelectedIndex()+1).getLayers().size()));
					lbl_width.setText(String.valueOf(projects.get(list.getSelectedIndex()+1).getLayers().get(1).getWidth()));
					lbl_length.setText(String.valueOf(projects.get(list.getSelectedIndex()+1).getLayers().get(1).getLength()));
				}
			}
		});
	}
}
