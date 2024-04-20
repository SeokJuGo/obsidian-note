export interface ColorScheme {
  light: string
  lightgray: string
  gray: string
  darkgray: string
  dark: string
  secondary: string
  tertiary: string
  highlight: string
}

export interface Theme {
  typography: {
    header: string
    body: string
    code: string
  }
  colors: {
    lightMode: ColorScheme
    darkMode: ColorScheme
  }
}

const DEFAULT_SANS_SERIF =
  '-apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, Arial, sans-serif'
const DEFAULT_MONO = "ui-monospace, SFMono-Regular, SF Mono, Menlo, monospace"

export function googleFontHref(theme: Theme) {
  const { code, header, body } = theme.typography
  return `https://fonts.googleapis.com/css2?family=${code}&family=${header}:wght@400;700&family=${body}:ital,wght@0,400;0,600;1,400;1,600&display=swap`
}

export function joinStyles(theme: Theme, ...stylesheet: string[]) {
  const fontFace = `
@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}
`;

  return `
${stylesheet.join("\n\n")}
${fontFace}
:root {
  --light: #f5f5f5; /* 밝은 회색 */
  --lightgray: #eeeeee; /* 밝은 회색 */
  --gray: #bdbdbd; /* 회색 */
  --darkgray: #757575; /* 어두운 회색 */
  --dark: #424242; /* 매우 어두운 회색 */
  --secondary: #333333; /* 검정색 */
  --tertiary: #9999ff; /* 파란색 */
  --highlight: #ccccff; /* 분홍색 */

  --headerFont: 'Pretendard-Regular', ${DEFAULT_SANS_SERIF};
  --bodyFont: 'Pretendard-Regular', ${DEFAULT_SANS_SERIF};
  --codeFont: 'Pretendard-Regular', ${DEFAULT_MONO};
}

:root[saved-theme="dark"] {
  --light: #000000; /* 어두운 회색 */
  --lightgray: #455a64; /* 어두운 회색 */
  --gray: #999999; /* 회색 */
  --darkgray: #eceff1; /* 밝은 회색 */
  --dark: #fafafa; /* 밝은 회색 */
  --secondary: #999999; /* 연한 파란색 */
  --tertiary: #9999ff; /* 연한 주황색 */
  --highlight: #ccccff; /* 연한 주황색 */
}
`
}
