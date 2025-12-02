<script>
export default {
  data() {
    return {
      chartData: {},
      //您可以通过修改 config-ucharts.js 文件中下标为 ['column'] 的节点来配置全局默认参数，如都是默认参数，此处可以不传 opts 。实际应用过程中 opts 只需传入与全局默认参数中不一致的【某一个属性】即可实现同类型的图表显示不同的样式，达到页面简洁的需求。
      opts: {
        color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
        padding: [15,15,0,5],
        touchMoveLimit: 24,
        enableScroll: true,
        legend: {},
        xAxis: {
          disableGrid: true,
          scrollShow: true,
          itemCount: 4
        },
        yAxis: {
          data: [
            {
              min: 0
            }
          ]
        },
        extra: {
          column: {
            type: "group",
            width: 30,
            activeBgColor: "#000000",
            activeBgOpacity: 0.08
          }
        }
      }
    };
  },
  onReady() {
    this.getServerData();
  },
  methods: {
    getServerData() {
      //模拟从服务器获取数据时的延时
      setTimeout(() => {
        //模拟服务器返回数据，如果数据格式和标准格式不同，需自行按下面的格式拼接
        let res = {
            categories: ["2018","2019","2020","2021","2022","2023"],
            series: [
              {
                name: "目标值",
                data: [35,36,31,33,13,34]
              },
              {
                name: "完成量",
                data: [18,27,21,24,6,28]
              }
            ]
          };
        this.chartData = JSON.parse(JSON.stringify(res));
      }, 500);
    },
  }
};
</script>

<template>
	<view class="index-container">
		<!-- 柱图 -->
		 <view class="charts-box">
		     <qiun-data-charts 
		       type="column"
		        :opts="opts"
		        :chartData="chartData"
		        :ontouch="true"
		     />
		   </view>
		   <!-- 饼图 -->
		   <view class="charts-box-radius-out">
			   <view class="charts-box-radius-in">
			   			   圆图
			   </view>
			   <view class="charts-box-radius-in">
			   			   圆图
			   </view>
		   </view>
		   <view class="charts-box">
			   
		   </view>
	</view>
</template>

<style>
.index-container {
	background-color: #00554b;
	min-height: 100vh;
	padding-bottom: 40rpx;
	padding-left: 20rpx;
	padding-right: 20rpx;
}	
.main-text{
	border-radius: 200rpx;
	color: black;
	font-size: 50rpx;
	text-align: center;

}
.charts-box {
    width: 90%;
    height: 300px;
	background-color: #fff;
	margin: 0rpx 30rpx;
	border-radius: 20rpx;
	padding: 20rpx;
	box-shadow: 0 4rpx 20rpx rgba(0, 0, 0, 0.1);
  }
.charts-box-radius-in {
    width: 45%;
    height: 200px;
	background-color: #fff;
	margin: 50rpx 0rpx;
	border-radius: 20rpx;
	padding: 20rpx;
	box-shadow: 0 4rpx 20rpx rgba(0, 0, 0, 0.1);
  }
.charts-box-radius-out {
  display: flex; 
  justify-content: space-between; 
  padding: 0 20rpx; 
}
</style>