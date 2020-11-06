package com.xdev.views.demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.daterange_picker.buisness.DateRangeModell;
import software.xdev.vaadin.daterange_picker.buisness.SimpleDateRange;
import software.xdev.vaadin.daterange_picker.buisness.SimpleDateRanges;
import software.xdev.vaadin.daterange_picker.ui.DateRangePicker;

@Route("server-view")
@PageTitle("ServerView")
@CssImport("./views/server-view/server-view.css")
public class ServerView extends Composite<VerticalLayout>
{
	protected static final List<SimpleDateRange> DATERANGE_VALUES = Arrays.asList(SimpleDateRanges.allValues());
	
	private final DateRangePicker<SimpleDateRange> dateRangePicker =
		new DateRangePicker<>(
			() -> new DateRangeModell<>(LocalDate.now(), LocalDate.now(), SimpleDateRanges.TODAY),
			DATERANGE_VALUES);
	
	private final TextArea taResult =
		new TextArea("ValueChangeEvent", "Change something in the datepicker to see the result");
	
	/*
	 * Fields
	 */
	public ServerView()
	{
		this.initUI();
	}
	
	protected void initUI()
	{
		this.taResult.setSizeFull();
		
		this.getContent().setPadding(false);
		this.getContent().add(new VerticalLayout(this.dateRangePicker), new VerticalLayout(this.taResult));
		this.getContent().getChildren().forEach(comp -> ((HasSize)comp).setHeight("50%"));
		this.getContent().setHeightFull();
		
		this.dateRangePicker.addValueChangeListener(ev ->
		{
			final DateRangeModell<SimpleDateRange> modell = ev.getModell();
			
			this.taResult.clear();
			// @formatter:off
			this.taResult.setValue(
					"DateRange: " + modell.getDateRange().getKey() + "\r\n" +
					"Start: " + modell.getStart() + "\r\n" +
					"End: " + modell.getEnd()
				);
			// @formatter:on
		});
	}
}
