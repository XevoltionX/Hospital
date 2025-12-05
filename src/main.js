import {createSSRApp} from "vue";
import App from "./App.vue";
import uvUI from '@/uni_modules/uv-ui-tools'
export function createApp() {
	const app = createSSRApp(App);
	return {
		app,
	};
	app.use(uvUI);
	
}
