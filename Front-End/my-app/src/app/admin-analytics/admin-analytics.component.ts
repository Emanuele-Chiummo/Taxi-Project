import { Component, OnInit, ViewChild } from '@angular/core';
import DatalabelsPlugin from 'chartjs-plugin-datalabels';
import { ChartConfiguration, ChartData, ChartEvent, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { TaxiServicesService } from '../services/taxi-services.service';

@Component({
  selector: 'app-admin-analytics',
  templateUrl: './admin-analytics.component.html',
  styleUrls: ['./admin-analytics.component.css']
})
export class AdminAnalyticsComponent implements OnInit {

  popularCourse: any[] = [];

  performance: any[] = [];

  entry: any[] = [];

  // Primo pie chart
  public pieChartOptions: ChartConfiguration['options'] = {
    plugins: {
      legend: {
        display: true,
        position: 'top',
      },
      datalabels: {
        formatter: (value: any, ctx: any) => {
          if (ctx.chart.data.labels) {
            return ctx.chart.data.labels[ctx.dataIndex];
          }
        },
      },
    },
  };

  public pieChartData: ChartData<'pie', number[], string | string[]> = {
    labels: [],
    datasets: [
      {
        data: [],
      },
    ],
  };

  public pieChartType: ChartType = 'pie';
  public pieChartPlugins = [DatalabelsPlugin];

  // Secondo pie chart per i dati di performance
  public performancePieChartOptions: ChartConfiguration['options'] = {
    plugins: {
      legend: {
        display: true,
        position: 'top',
      },
      datalabels: {
        formatter: (value: any, ctx: any) => {
          if (ctx.chart.data.labels) {
            return ctx.chart.data.labels[ctx.dataIndex];
          }
        },
      },
    },
  };

  public performancePieChartData: ChartData<'pie', number[], string | string[]> = {
    labels: [],
    datasets: [
      {
        data: [],
      },
    ],
  };

  public performancePieChartType: ChartType = 'pie';
  public performancePieChartPlugins = [DatalabelsPlugin];

  constructor(private ts: TaxiServicesService) {}

  ngOnInit(): void {
    this.ts.getTaxiPerformace().subscribe(
      (response) => {
        this.performance = response;
        this.updatePerformanceChartData();
        this.updateEntryChartData();
      },
      (error) => {
        console.log(error);
      }
    );

    this.ts.getChartData().subscribe(
      (response) => {
        this.popularCourse = response;
        this.updateChartData();
        

      },
      (error) => {
        console.log(error);
      }
    );

    this.ts.getEntryPerformance().subscribe( 
      (response) => {
        this.entry = response;
        this.updateEntryChartData();
      },
      (error) => {
        console.log(error);
      }
    );

  }

  //Bar Chart 

  public barChartOptionsEntry: ChartConfiguration['options'] = {
    // We use these empty structures as placeholders for dynamic theming.
    scales: {
      x: {},
      y: {
        min: 10,
      },
    },
    plugins: {
      legend: {
        display: true,
      },
      datalabels: {
        anchor: 'end',
        align: 'end',
      },
    },
  };

  public barChartTypeEntry: ChartType = 'bar';
  public barChartPluginsEntry = [DatalabelsPlugin];

  public barChartDataEntry: ChartData<'bar'> = {
    //labels: ['2006', '2007', '2008', '2009', '2010', '2011', '2012'],
    labels: this.entry.map((item) => item[0]),
    datasets: [
      
      { data: this.entry.map((item) => item[0]), label: 'Performance'},
      
      
      //{ data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' },
    ],
  };

  // events
  public chartClicked({
    event,
    active,
  }: {
    event?: ChartEvent;
    active?: object[];
  }): void {
  }

  public chartHovered({
    event,
    active,
  }: {
    event?: ChartEvent;
    active?: object[];
  }): void {
  }


  @ViewChild(BaseChartDirective) chart: BaseChartDirective | undefined;
  

  private updateChartData(): void {
    const labels = this.popularCourse.map((item) => `${item[0]} - ${item[1]}`);
    const dataValues = this.popularCourse.map(item => item[2]);

    this.pieChartData.labels = labels;
    this.pieChartData.datasets[0].data = dataValues;

    this.chart?.update();
  }

  private updatePerformanceChartData(): void {
    const labels = this.performance.map((item) => item[0]);
    const dataValues = this.performance.map(item => +item[1]);

    this.performancePieChartData.labels = labels;

    this.performancePieChartData.datasets[0].data = dataValues;

    this.chart?.update();
  }

  private updateEntryChartData(): void {

    const labels = this.entry.map((item) => item[1]);
    const dataValues = this.entry.map(item => +item[2]);

    this.barChartDataEntry.labels = labels;

    this.barChartDataEntry.datasets[0].data = dataValues;

    this.chart?.update();
  }
}
