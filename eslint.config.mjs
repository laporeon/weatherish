import prettier from 'eslint-plugin-prettier';
import prettierConfig from 'eslint-config-prettier';
import typescriptParser from '@typescript-eslint/parser';

export default [
  {
    files: ['**/*.{ts,js,mjs}'],
    languageOptions: {
      parser: typescriptParser,
    },
    plugins: {
      prettier,
    },
    rules: {
      ...prettierConfig.rules,
    },
    ignores: ['eslint.config.mjs', 'node_modules'],
  },
];
