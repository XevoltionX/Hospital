// composables/useColumnChart.js
import { ref } from 'vue'
import { onReady } from '@dcloudio/uni-app' // 导入uniapp生命周期

/**
 * 柱状图复用逻辑（Vue3 组合式函数）
 * @returns { chartData, opts, getServerData } 响应式数据和方法
 */
export function useColumnChart() {
  // 响应式数据（替代 Vue2 的 data）
  const chartData = ref({})
  
  // 图表配置项（响应式，如需动态修改可保留 ref，无需修改则可直接用普通对象）
  const opts = ref({
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
      data: [{ min: 0 }]
    },
    extra: {
      column: {
        type: "group",
        width: 30,
        activeBgColor: "#000000",
        activeBgOpacity: 0.08
      }
    }
  })

  const getServerData = () => {
    // 模拟接口请求延时
    setTimeout(() => {
      const res = {
        categories: ["2018","2019","2020","2021","2022","2023"],
        series: [
          { name: "目标值", data: [35,36,31,33,13,34] },
          { name: "完成量", data: [18,27,21,24,6,28] }
        ]
      };
	  
      chartData.value = JSON.parse(JSON.stringify(res)); 
    }, 500);
  }
  onReady(() => {
    getServerData();
  })
  return {
    chartData,
    opts,
    getServerData 
  }
}