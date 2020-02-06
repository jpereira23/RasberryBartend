package com.bartend.app;

import java.awt.*;
import java.awt.event.*;
import java.net.*; 
import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*; 

class IconButton extends JButton{

	public IconButton(String buttonTitle){
		super();
		setBackground(new Color(16,16,16));
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
        setIcon(new ImageIcon(getClass().getResource("./cog.png")));
		setBounds(715,25,60, 58);
	}
}