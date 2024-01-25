import { Component, OnInit, ViewChild } from '@angular/core';
import DatalabelsPlugin from 'chartjs-plugin-datalabels';
import { ChartConfiguration, ChartData, ChartType } from 'chart.js';
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
        console.log('Taxi Performanti : ', this.performance);
        this.updatePerformanceChartData();
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
    // Aggiorna il terzo grafico con i dati di performance
    const labels = this.performance.map((item) => item[0]);
    const dataValues = this.performance.map(item => +item[1]);

    this.performancePieChartData.labels = labels;

    console.log('Data Values : ', dataValues);

    console.log('labels : ', labels);
    this.performancePieChartData.datasets[0].data = dataValues;

    this.chart?.update();
  }
}
