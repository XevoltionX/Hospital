// composables/usePieChart.js
import { ref } from 'vue'
import { onReady } from '@dcloudio/uni-app' // 导入uniapp专属生命周期

/**
 * 饼图复用逻辑（Vue3 组合式函数）
 * @returns { chartData, opts, getServerData } 响应式数据和方法
 */
export function usePieChart() {
  // 响应式数据（替代 Vue2 的 data 选项）
  const chartData = ref({})

  // 饼图配置项（如需动态修改则保留 ref，静态配置可直接用普通对象）
  const opts = ref({
    color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
    padding: [5,5,5,5],
    enableScroll: false,
    extra: {
      pie: {
        activeOpacity: 0.5,
        activeRadius: 10,
        offsetAngle: 0,
        labelWidth: 15,
        border: false,
        borderWidth: 3,
        borderColor: "#FFFFFF"
      }
    }
  })

  // 获取图表数据方法（替代 Vue2 的 methods）
  const getServerData = () => {
    // 模拟服务器请求延时
    setTimeout(() => {
      const res = {
        series: [
          {
            data: [{"name":"一班","value":50},{"name":"二班","value":30},{"name":"三班","value":20},{"name":"四班","value":18},{"name":"五班","value":8}]
          }
        ]
      };
      chartData.value = JSON.parse(JSON.stringify(res)); // ref 数据需通过 .value 修改
    }, 500);
  }
）
  onReady(() => {
    getServerData();
  })

  // 导出供组件使用的响应式数据和方法
  return {
    chartData,
    opts,
    getServerData // 如需手动刷新数据，可导出此方法
  }
}